package com.rays.ctl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.MarksheetDTO;
import com.rays.form.MarksheetForm;
import com.rays.service.MarksheetServiceInt;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Transactional
@RestController
@RequestMapping("Jasper")
public class JasperCtl extends BaseCtl<MarksheetForm, MarksheetDTO, MarksheetServiceInt> {

	private SessionFactory sessionFactory;

	@Autowired
	private ServletContext context;

	@PersistenceContext
	private EntityManager entityManager;

	@GetMapping(value = "report", produces = MediaType.APPLICATION_PDF_VALUE)
	public void display(HttpServletRequest request, HttpServletResponse response)
			throws JRException, SQLException, IOException {

		System.out.println("*************** Jasper Ctl ****************");

		// Read application.properties
		ResourceBundle rb = ResourceBundle.getBundle("application");
		String jrxmlPath = rb.getString("jasper");

		System.out.println("JRXML Path: " + jrxmlPath);

		// Compile JRXML
		JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlPath);

		// DB Connection
		sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
		Connection con = sessionFactory.getSessionFactoryOptions()
				.getServiceRegistry()
				.getService(ConnectionProvider.class)
				.getConnection();

		// Parameters (empty for now)
		Map<String, Object> map = new HashMap<>();

		// Fill the report
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, con);

		// Export PDF
		byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "inline; filename=marksheetReport.pdf");
		response.getOutputStream().write(pdf);
		response.getOutputStream().flush();

		System.out.println("PDF Generated Successfully");

		// Close DB connection
		con.close();
	}
}
