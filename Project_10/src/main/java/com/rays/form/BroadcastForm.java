package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.BroadcastDTO;

public class BroadcastForm extends BaseForm {

	@NotEmpty(message = "Please Enter broadcastCode")
	private String broadcastCode;

	@NotEmpty(message = "Please Enter message")
	private String message;
 
	@NotEmpty(message = "Please Enter sentBy")
	@Pattern(regexp = "^[A-Za-z ]{2,50}$", message = "Invalid Sender Name")
	private String sentBy;

	@NotEmpty(message = "Please Enter status")
	private String status;

	// Getters & Setters

	public String getBroadcastCode() {
		return broadcastCode;
	}

	public void setBroadcastCode(String broadcastCode) {
		this.broadcastCode = broadcastCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSentBy() {
		return sentBy;
	}

	public void setSentBy(String sentBy) {
		this.sentBy = sentBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// Convert Form → DTO

	@Override
	public BaseDTO getDto() {

		BroadcastDTO dto = initDTO(new BroadcastDTO());

		dto.setBroadcastCode(broadcastCode);
		dto.setMessage(message);
		dto.setSentBy(sentBy);
		dto.setStatus(status);

		return dto;
	}
}