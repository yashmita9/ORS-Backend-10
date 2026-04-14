package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.UploadDAOInt;
import com.rays.dto.UploadDTO;

@Service
@Transactional
public class UploadServiceImpl extends BaseServiceImpl<UploadDTO, UploadDAOInt> implements UploadServiceInt{ 

}
