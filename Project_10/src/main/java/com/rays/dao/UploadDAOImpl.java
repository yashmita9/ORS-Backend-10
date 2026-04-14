package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.UploadDTO;

@Repository
public class UploadDAOImpl extends BaseDAOImpl<UploadDTO> implements UploadDAOInt{

	@Override
	protected List<Predicate> getWhereClause(UploadDTO dto, CriteriaBuilder builder, Root<UploadDTO> qRoot) {

	    List<Predicate> whereCondition = new ArrayList<>();

	    if (!isEmptyString(dto.getUploadCode())) {
	        whereCondition.add(
	            builder.like(qRoot.get("uploadCode"), dto.getUploadCode() + "%")
	        );
	    }

	    if (!isEmptyString(dto.getFileName())) {
	        whereCondition.add(
	            builder.like(qRoot.get("fileName"), dto.getFileName() + "%")
	        );
	    }

	    if (!isEmptyString(dto.getUploadedBy())) {
	        whereCondition.add(
	            builder.like(qRoot.get("uploadedBy"), dto.getUploadedBy() + "%")
	        );
	    }

	    if (!isEmptyString(dto.getStatus())) {
	        whereCondition.add(
	            builder.like(qRoot.get("status"), dto.getStatus() + "%")
	        );
	    }

	    return whereCondition;
	}

	@Override
	public Class<UploadDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return UploadDTO.class;
	}

}
