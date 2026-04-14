package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.UploadDTO;

public class UploadForm extends BaseForm {

    @NotEmpty(message = "Please Enter uploadCode")
    private String uploadCode;

    @NotEmpty(message = "Please Enter fileName")
    private String fileName;

    @NotEmpty(message = "Please Enter uploadedBy")
    @Pattern(regexp = "^[A-Za-z ]{2,50}$", message = "Invalid Patient Name")
    private String uploadedBy;

    @NotEmpty(message = "Please Enter status")
    private String status;

    // Getters & Setters

    public String getUploadCode() {
        return uploadCode;
    }

    public void setUploadCode(String uploadCode) {
        this.uploadCode = uploadCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Convert Form → DTO

    @Override
    public BaseDTO getDto() {

        UploadDTO dto = initDTO(new UploadDTO());

        dto.setUploadCode(uploadCode);
        dto.setFileName(fileName);
        dto.setUploadedBy(uploadedBy);
        dto.setStatus(status);

        return dto;
    }
}