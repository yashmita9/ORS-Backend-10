package com.rays.dao;

import com.rays.common.DropdownList;

public class SimpleDropdownDTO implements DropdownList {

	private String key;
	private String value;

	public SimpleDropdownDTO(String key, String value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String getKey() {
		return key;
	}

	@Override
	public String getValue() {
		return value;
	}
}

