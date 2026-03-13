package com.rays.dto;

import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "St_Bank")
public class BankDTO extends BaseDTO {

	@Column(name = "Account_Holder", length = 50)
	private String accountHolder;

	@Column(name = "Account_Number", length = 50)
	private String accountNumber;

	@Column(name = "Account_Type", length = 50)
	private String accountType;

	@Column(name = "Balance", length = 50)
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
	public String getValue() {
		// TODO Auto-generated method stub
		return accountHolder;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "accountNumber";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return accountNumber;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "accountNumber";
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("accountHolder", "asc");

		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("accountHolder", accountHolder);
		return map;
	}

}