package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.BroadcastDTO;

@Repository
public class BroadcastDAOImpl extends BaseDAOImpl<BroadcastDTO> implements BroadcastDAOInt {

	@Override
	protected List<Predicate> getWhereClause(BroadcastDTO dto, CriteriaBuilder builder, Root<BroadcastDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<>(); 

		if (!isEmptyString(dto.getBroadcastCode())) {
			whereCondition.add(builder.like(qRoot.get("broadcastCode"), dto.getBroadcastCode() + "%"));
		}

		if (!isEmptyString(dto.getMessage())) {
			whereCondition.add(builder.like(qRoot.get("message"), dto.getMessage() + "%"));
		}

		if (!isEmptyString(dto.getSentBy())) {
			whereCondition.add(builder.like(qRoot.get("sentBy"), dto.getSentBy() + "%"));
		}

		if (!isEmptyString(dto.getStatus())) {
			whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus() + "%"));
		}

		return whereCondition;
	}

	@Override
	public Class<BroadcastDTO> getDTOClass() {
		return BroadcastDTO.class;
	}
}