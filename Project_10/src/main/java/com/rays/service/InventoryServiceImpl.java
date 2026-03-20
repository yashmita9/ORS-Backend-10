package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.InventoryDAOInt;
import com.rays.dto.InventoryDTO;

@Service
@Transactional
public class InventoryServiceImpl extends BaseServiceImpl<InventoryDTO, InventoryDAOInt> implements InventoryServiceInt{

}
