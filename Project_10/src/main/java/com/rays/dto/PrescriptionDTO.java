package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "St_Prescription")
public class PrescriptionDTO extends BaseDTO {

    @Column(name = "Patient_Name", length = 50)
    private String patientName;

    @Column(name = "Doctor_Name", length = 50)
    private String doctorName;

    @Column(name = "Mobile_Number", length = 15)
    private String mobileNumber;

    @Column(name = "Prescribed_Date")
    private Date prescribedDate;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Date getPrescribedDate() {
        return prescribedDate;
    }

    public void setPrescribedDate(Date prescribedDate) {
        this.prescribedDate = prescribedDate;
    }

    @Override
    public String getValue() {
        return patientName;
    }

    @Override
    public String getUniqueKey() {
        return "mobileNumber";
    }

    @Override
    public String getUniqueValue() {
        return mobileNumber;
    }

    @Override
    public String getLabel() {
        return "mobileNumber";
    }

    @Override
    public LinkedHashMap<String, String> orderBY() {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("patientName", "asc");
        return map;
    }

    @Override
    public LinkedHashMap<String, Object> uniqueKeys() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("mobileNumber", mobileNumber);
        return map;
    }
}