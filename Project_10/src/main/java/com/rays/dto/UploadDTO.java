package com.rays.dto;

import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "St_Upload")
public class UploadDTO extends BaseDTO {

    @Column(name = "Upload_Id")
    private Long uploadId;

    @Column(name = "Upload_Code", length = 50)
    private String uploadCode;

    @Column(name = "File_Name", length = 100)
    private String fileName;

    @Column(name = "Uploaded_By", length = 50)
    private String uploadedBy;

    @Column(name = "Status", length = 20)
    private String status;

    // Getters & Setters

    public Long getUploadId() {
        return uploadId;
    }

    public void setUploadId(Long uploadId) {
        this.uploadId = uploadId;
    }

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

    // BaseDTO methods

    @Override
    public String getValue() {
        return fileName;
    }

    @Override
    public String getUniqueKey() {
        return "uploadCode";
    }

    @Override
    public String getUniqueValue() {
        return uploadCode;
    }

    @Override
    public String getLabel() {
        return "uploadCode";
    }

    @Override
    public LinkedHashMap<String, String> orderBY() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("uploadCode", "asc");
        return map;
    }

    @Override
    public LinkedHashMap<String, Object> uniqueKeys() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("uploadCode", uploadCode);
        return map;
    }
}