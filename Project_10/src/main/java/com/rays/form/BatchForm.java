package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.BatchDTO;

public class BatchForm extends BaseForm {

	@NotEmpty(message = "Please Enter batchCode")
	private String batchCode;

	@NotNull(message = "Please Enter totalMessages")
	private Integer totalMessages;

	@NotNull(message = "Please Enter processedCount")
	private Integer processedCount;

	@NotEmpty(message = "Please Enter status")
	private String status;

	// Getter Setter

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	public Integer getTotalMessages() {
		return totalMessages;
	}

	public void setTotalMessages(Integer totalMessages) {
		this.totalMessages = totalMessages;
	}

	public Integer getProcessedCount() {
		return processedCount;
	}

	public void setProcessedCount(Integer processedCount) {
		this.processedCount = processedCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// DTO Conversion

	@Override
	public BaseDTO getDto() {

		BatchDTO dto = initDTO(new BatchDTO());

		dto.setBatchCode(batchCode);
		dto.setTotalMessages(totalMessages);
		dto.setProcessedCount(processedCount);
		dto.setStatus(status);

		return dto;
	}
}