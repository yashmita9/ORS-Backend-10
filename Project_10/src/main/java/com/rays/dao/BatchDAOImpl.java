package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.BatchDTO;

@Repository
public class BatchDAOImpl extends BaseDAOImpl<BatchDTO> implements BatchDAOInt {

	@Override
	protected List<Predicate> getWhereClause(BatchDTO dto, CriteriaBuilder builder, Root<BatchDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<>();

		// batchCode filter
		if (!isEmptyString(dto.getBatchCode())) {
			whereCondition.add(builder.like(qRoot.get("batchCode"), dto.getBatchCode() + "%"));
		}

		// status filter
		if (!isEmptyString(dto.getStatus())) {
			whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus() + "%"));
		}

		// totalMessages filter (exact match)
		if (dto.getTotalMessages() != null) {
			whereCondition.add(builder.equal(qRoot.get("totalMessages"), dto.getTotalMessages()));
		}

		// processedCount filter (exact match)
		if (dto.getProcessedCount() != null) {
			whereCondition.add(builder.equal(qRoot.get("processedCount"), dto.getProcessedCount()));
		}

		return whereCondition;
	}

	@Override
	public Class<BatchDTO> getDTOClass() {
		return BatchDTO.class;
	}
}