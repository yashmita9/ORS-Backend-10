package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.EventDTO;

@Repository
public class EventDAOImpl extends BaseDAOImpl<EventDTO> implements EventDAOInt {

	@Override
	protected List<Predicate> getWhereClause(EventDTO dto, CriteriaBuilder builder, Root<EventDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<>();

		if (!isEmptyString(dto.getEventCode())) {
			whereCondition.add(builder.like(qRoot.get("eventCode"), dto.getEventCode() + "%"));
		}

		if (!isEmptyString(dto.getEventName())) {
			whereCondition.add(builder.like(qRoot.get("eventName"), dto.getEventName() + "%"));
		}

		if (!isEmptyString(dto.getStatus())) {
			whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus() + "%"));
		}

		if (dto.getEventDate() != null) {
			whereCondition.add(builder.equal(qRoot.get("eventTime"), dto.getEventDate()));
		}

		return whereCondition;
	}

	@Override
	public Class<EventDTO> getDTOClass() {
		return EventDTO.class;
	}

}