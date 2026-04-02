package com.rays.service;

import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rays.common.UserContext;
import com.rays.dao.StudentDAOImpl;
import com.rays.dto.StudentDTO;

@Service
@Transactional
public class ExcelService {

    @Autowired
    private StudentDAOImpl studentDao;

    
    private boolean isRowEmpty(Row row) {
        if (row == null) return true;

        for (int i = 0; i < row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }
    
    public void readExcel(MultipartFile file, UserContext userContext) throws Exception {

        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        // 🔥 Best way to read any type of cell
        DataFormatter formatter = new DataFormatter();

        for (Row row : sheet) {

            // skip header row
            if (row.getRowNum() == 0) continue;

            if (row == null) continue;
            
            if (isRowEmpty(row)) continue; 

            StudentDTO dto = new StudentDTO();

            // ✅ Safe reading using formatter + null check

            dto.setEnrolNo(formatter.formatCellValue(row.getCell(0)));
            dto.setFirstName(formatter.formatCellValue(row.getCell(1)));
            dto.setLastName(formatter.formatCellValue(row.getCell(2)));

            // DOB (date handle separately)
            Cell dobCell = row.getCell(3);
            if (dobCell != null && dobCell.getCellType() == CellType.NUMERIC) {
                dto.setDob(dobCell.getDateCellValue());
            }

            // Phone
            dto.setPhoneNo(formatter.formatCellValue(row.getCell(4)));

            // Email
            dto.setEmail(formatter.formatCellValue(row.getCell(5)));

            String collegeIdStr = formatter.formatCellValue(row.getCell(6));

            if (!collegeIdStr.isEmpty()) {
                dto.setCollegeId(Long.parseLong(collegeIdStr));
            } else {
                dto.setCollegeId(0L); // default value
            }

            // College Name
            dto.setCollegeName(formatter.formatCellValue(row.getCell(7)));

            // ⚠️ userContext null issue fix
            if (userContext == null) {
                userContext = new UserContext();
                userContext.setLoginId("system"); // default value
            }

            studentDao.add(dto, userContext);
        }

        workbook.close();
    }
}