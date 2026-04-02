package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.PrescriptionDTO;

public class PrescriptionForm extends BaseForm {

    @NotEmpty(message = "Please Enter patientName")
    private String patientName;

    @NotEmpty(message = "Please Enter doctorName")
    private String doctorName;

    @NotEmpty(message = "Please Enter mobileNumber")
    private String mobileNumber;

    @NotNull(message = "Please Enter prescribedDate")
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
    public BaseDTO getDto() {

        PrescriptionDTO dto = initDTO(new PrescriptionDTO());
        dto.setPatientName(patientName);
        dto.setDoctorName(doctorName);
        dto.setMobileNumber(mobileNumber);
        dto.setPrescribedDate(prescribedDate);

        return dto;
    }
}