package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.BatchDAOInt;
import com.rays.dto.BatchDTO;

@Service
@Transactional
public class BatchServiceImpl extends BaseServiceImpl<BatchDTO, BatchDAOInt> implements BatchServiceInt {

    @Autowired
    BatchDAOInt batchDAOInt;

}