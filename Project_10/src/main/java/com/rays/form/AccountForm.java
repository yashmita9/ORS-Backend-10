package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.AccountDTO;

public class AccountForm extends BaseForm {

    @NotEmpty(message = "Please Enter accountCode")
    private String accountCode;

    @NotEmpty(message = "Please Enter userName")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "UserName must contain only alphabets")
    private String userName;

    @NotEmpty(message = "Please Enter accountType")
    private String accountType;

    @NotEmpty(message = "Please Enter status")
    private String status;

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // DTO convert

    @Override
    public BaseDTO getDto() {

        AccountDTO dto = initDTO(new AccountDTO());

        dto.setAccountCode(accountCode);
        dto.setUserName(userName);
        dto.setAccountType(accountType);
        dto.setStatus(status);

        return dto;
    }
}