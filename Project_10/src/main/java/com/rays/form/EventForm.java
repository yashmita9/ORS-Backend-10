package com.rays.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.EventDTO;

public class EventForm extends BaseForm {

	@NotEmpty(message = "Please Enter eventCode")
	private String eventCode;

	@NotEmpty(message = "Please Enter eventName")
	private String eventName;

	@NotNull(message = "Please Enter eventTime")
	private Date eventDate;

	@NotEmpty(message = "Please Enter status")
	private String status;

	// Getters & Setters

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
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

		EventDTO dto = initDTO(new EventDTO());

		dto.setEventCode(eventCode);
		dto.setEventName(eventName);
		dto.setStatus(status);

		dto.setEventDate(eventDate);

		return dto;
	}
}