package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.AccountDTO;

@Repository
public class AccountDAOImpl extends BaseDAOImpl<AccountDTO> implements AccountDAOInt {

    @Override
    protected List<Predicate> getWhereClause(AccountDTO dto, CriteriaBuilder builder, Root<AccountDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<>();

        if (!isEmptyString(dto.getAccountCode())) {
            whereCondition.add(builder.like(qRoot.get("accountCode"), dto.getAccountCode() + "%"));
        }

        if (!isEmptyString(dto.getUserName())) {
            whereCondition.add(builder.like(qRoot.get("userName"), dto.getUserName() + "%"));
        }

        if (!isEmptyString(dto.getAccountType())) {
            whereCondition.add(builder.like(qRoot.get("accountType"), dto.getAccountType() + "%"));
        }

        if (!isEmptyString(dto.getStatus())) {
            whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus() + "%"));
        }

        return whereCondition;
    }

    @Override
    public Class<AccountDTO> getDTOClass() {
        return AccountDTO.class;
    }
}