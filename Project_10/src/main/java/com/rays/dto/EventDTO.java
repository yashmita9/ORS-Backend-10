package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "St_Event")
public class EventDTO extends BaseDTO {

    @Column(name = "Event_Code", length = 50)
    private String eventCode;

    @Column(name = "Event_Name", length = 100)
    private String eventName;

    @Column(name = "Event_Date")
    private Date eventDate;

    @Column(name = "Status", length = 20)
    private String status;

    // Getters & Setters

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
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
        return eventName;
    }

    @Override
    public String getUniqueKey() {
        return "eventCode";
    }

    @Override
    public String getUniqueValue() {
        return eventCode;
    }

    @Override
    public String getLabel() {
        return "eventCode";
    }

    @Override
    public LinkedHashMap<String, String> orderBY() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("eventCode", "asc");
        return map;
    }

    @Override
    public LinkedHashMap<String, Object> uniqueKeys() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("eventCode", eventCode);
        return map;
    }
}