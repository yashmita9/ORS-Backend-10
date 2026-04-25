package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.EventDAOInt;
import com.rays.dto.EventDTO;

@Service
@Transactional
public class EventServiceImpl extends BaseServiceImpl<EventDTO, EventDAOInt> implements EventServiceInt {

}