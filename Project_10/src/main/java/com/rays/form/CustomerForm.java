package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.ParseConversionEvent;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CustomerDTO;
import com.rays.dto.UserDTO;


public class CustomerForm extends BaseForm {

	@NotEmpty(message = "please enter clientName")
	private String clientName;

	@NotEmpty(message = "please enter location")
	private String location;

	@NotNull(message = "please enter contactNumber")
	private String contactNumber;

	@NotEmpty(message = "please entwer importance")
	private String importance;

	@Override
	public BaseDTO getDto() {

		CustomerDTO dto = initDTO(new CustomerDTO());
		dto.setClientName(clientName);
		dto.setLocation(location);
		dto.setContactNumber(Long.parseLong(contactNumber));
		dto.setImportance(importance);
		return dto;
	}

}
