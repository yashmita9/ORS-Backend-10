package com.rays.dto;

import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "St_Account")
public class AccountDTO extends BaseDTO {

	@Column(name = "Account_Code", length = 50)
	private String accountCode;

	@Column(name = "User_Name", length = 50)
	private String userName;

	@Column(name = "Account_Type", length = 50)
	private String accountType;

	@Column(name = "Status", length = 20)
	private String status;

	// Getter & Setter

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

	// BaseDTO methods override

	@Override
	public String getValue() {
		return userName;
	}

	@Override
	public String getUniqueKey() {
		return "accountCode";
	}

	@Override
	public String getUniqueValue() {
		return accountCode;
	}

	@Override
	public String getLabel() {
		return "accountCode";
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("userName", "asc");
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("accountCode", accountCode);
		return map;
	}
}