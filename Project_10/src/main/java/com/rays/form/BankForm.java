package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.BankDTO;

public class BankForm extends BaseForm {

	@NotEmpty(message = "Please Enter accountHolder")
	private String accountHolder;

	@NotEmpty(message = "Please Enter accountNumber")
	private String accountNumber;

	@NotEmpty(message = "Please Enter accountType")
	private String accountType;

	@NotEmpty(message = "Please Enter balance")
	private String balance;

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	
	@Override
	public BaseDTO getDto() {
		
		BankDTO dto = initDTO(new BankDTO());
		dto.setAccountHolder(accountHolder);
		dto.setAccountNumber(accountNumber);
		dto.setAccountType(accountType);
		dto.setBalance(balance);
		
		return dto;
	}
	
}