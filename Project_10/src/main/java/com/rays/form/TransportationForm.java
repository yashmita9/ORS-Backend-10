package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.TransportationDTO;

public class TransportationForm extends BaseForm{
	
	@NotEmpty(message = "please enter description")
	private String description;

	@NotNull(message = "Book Date is required")
	private Date bookDate;
	
	@NotNull(message = "please select mode")
	private Long mode;

	@NotNull(message = "please enter cost")
	private Long cost;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getMode() {
		return mode;
	}

	public void setMode(long mode) {
		this.mode = mode;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}
	
	@Override
	public BaseDTO getDto() {
		TransportationDTO dto = initDTO(new TransportationDTO());
		dto.setDescription(description);
		dto.setMode(mode);;
		dto.setBookDate(bookDate);
		dto.setCost(cost);;
		return dto;
	}

}
