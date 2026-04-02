package com.rays.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.rays.common.BaseCtl;
import com.rays.common.UserContext;
import com.rays.service.ExcelService;

@RestController
@RequestMapping("/api")
public class ExcelCtl {   // ✅ yaha change

    @Autowired
    private ExcelService excelService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {

            UserContext userContext = new UserContext();
            userContext.setLoginId("admin");
            userContext.setOrgId(1L);
            userContext.setOrgName("TestOrg");

            excelService.readExcel(file, userContext);

            return "File processed successfully";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}