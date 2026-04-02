package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.PrescriptionDAOImpl;
import com.rays.dto.PrescriptionDTO;

@Transactional
@Service
public class PrescriptionServiceImpl extends BaseServiceImpl<PrescriptionDTO, PrescriptionDAOImpl> implements PrescriptionServiceInt{

}
