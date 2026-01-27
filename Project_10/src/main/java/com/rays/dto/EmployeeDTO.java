package com.rays.dto;

import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_EMPLOYEE")
public class EmployeeDTO extends BaseDTO {

	@Column(name = "NAME", length = 50)
	private String name;
	
	@Column(name = "SALARY", length = 50)
	private String salary;
	
	@Column(name = "POST", length = 50)
	private String post;
	
	@Column(name = "ADDRESS", length = 50)
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String getValue() {
	    return name;
	}

	@Override
	public String getUniqueKey() {
	    return "name";
	}

	@Override
	public String getUniqueValue() {
	    return name;
	}

	@Override
	public String getLabel() {
	    return "emp name";
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
	    LinkedHashMap<String, String> map = new LinkedHashMap<>();
	    map.put("name", "asc");
	    return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
	    LinkedHashMap<String, Object> map = new LinkedHashMap<>();
	    map.put("name", name);
	    return map;
	}
}