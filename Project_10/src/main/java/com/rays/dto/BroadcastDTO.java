package com.rays.dto;

import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "St_Broadcast")
public class BroadcastDTO extends BaseDTO {

    @Column(name = "Broadcast_Id")
    private Long broadcastId;

    @Column(name = "Broadcast_Code", length = 50)
    private String broadcastCode;

    @Column(name = "Message", length = 255)
    private String message;

    @Column(name = "Sent_By", length = 50)
    private String sentBy;

    @Column(name = "Status", length = 20)
    private String status;

    // Getters & Setters

    public Long getBroadcastId() {
        return broadcastId;
    }

    public void setBroadcastId(Long broadcastId) {
        this.broadcastId = broadcastId;
    }

    public String getBroadcastCode() {
        return broadcastCode;
    }

    public void setBroadcastCode(String broadcastCode) {
        this.broadcastCode = broadcastCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSentBy() {
        return sentBy;
    }

    public void setSentBy(String sentBy) {
        this.sentBy = sentBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // BaseDTO methods

    @Override
    public String getValue() {
        return message;
    }

    @Override
    public String getUniqueKey() {
        return "broadcastCode";
    }

    @Override
    public String getUniqueValue() {
        return broadcastCode;
    }

    @Override
    public String getLabel() {
        return "broadcastCode";
    }

    @Override
    public LinkedHashMap<String, String> orderBY() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("broadcastCode", "asc");
        return map;
    }

    @Override
    public LinkedHashMap<String, Object> uniqueKeys() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("broadcastCode", broadcastCode);
        return map;
    }
}