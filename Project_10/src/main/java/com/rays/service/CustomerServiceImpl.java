package com.rays.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.CustomerDAOInt;
import com.rays.dto.CustomerDTO;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<CustomerDTO, CustomerDAOInt> implements CustomerServiceInt {

	@Override
	public CustomerDTO findByName(String name, UserContext userContext) {
		// TODO Auto-generated method stub
		return baseDao.findByUniqueKey("clientName", name , userContext);
	}

	

	
}
