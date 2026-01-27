package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.EmployeeDTO;

public class EmployeeForm extends BaseForm {

	@NotEmpty(message = "Please Enter Name")
	private String name;

	@NotEmpty(message = "Please Enter Salary")
	private String salary;

	@NotEmpty(message = "Please Enter Post")
	private String post;

	@NotEmpty(message = "Please Enter Address")
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
	public BaseDTO getDto() {
		EmployeeDTO dto = initDTO(new EmployeeDTO());
		
		dto.setName(name);
		dto.setSalary(salary);
		dto.setPost(post);
		dto.setAddress(address);
		
		return dto;
	}
	
}