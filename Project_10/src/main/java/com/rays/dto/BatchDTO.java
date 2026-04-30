package com.rays.dto;

import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_BATCH")
public class BatchDTO extends BaseDTO {

    @Column(name = "batch_code", length = 50)
    private String batchCode;

    @Column(name = "total_mesg")
    private Integer totalMessages;

    @Column(name = "processed_count")
    private Integer processedCount;

    @Column(name = "status", length = 20)
    private String status;

    // Getter Setter

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public Integer getTotalMessages() {
        return totalMessages;
    }

    public void setTotalMessages(Integer totalMessages) {
        this.totalMessages = totalMessages;
    }

    public Integer getProcessedCount() {
        return processedCount;
    }

    public void setProcessedCount(Integer processedCount) {
        this.processedCount = processedCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // BaseDTO methods override

    @Override
    public String getValue() {
        return batchCode;
    }

    @Override
    public String getUniqueKey() {
        return "batchCode";
    }

    @Override
    public String getUniqueValue() {
        return batchCode;
    }

    @Override
    public String getLabel() {
        return "batchCode";
    }

    @Override
    public LinkedHashMap<String, String> orderBY() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("batchCode", "asc");
        return map;
    }

    @Override
    public LinkedHashMap<String, Object> uniqueKeys() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("batchCode", batchCode);
        return map;
    }
}