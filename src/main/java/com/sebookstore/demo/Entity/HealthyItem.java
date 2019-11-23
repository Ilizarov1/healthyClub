package com.sebookstore.demo.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

@Entity
public class HealthyItem implements Serializable
{
    private static final long serialVersionUID=1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHealthyitemName() {
        return healthyitemName;
    }

    public void setHealthyitemName(String healthyitemName) {
        this.healthyitemName = healthyitemName;
    }

    public String getJsName() {
        return jsName;
    }

    public void setJsName(String jsName) {
        this.jsName = jsName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNow() {
        return now;
    }

    public void setNow(int now) {
        this.now = now;
    }


    @Id
    @GeneratedValue
    private Long id;

    public Long getJsId() {
        return jsId;
    }

    public void setJsId(Long jsId) {
        this.jsId = jsId;
    }

    @Column
    private String healthyitemName;
    @Column
    private String jsName;
    @Column
    private Long jsId;
    @Column
    private double price;
    @Column
    private int space;
    @Column
    private String type;
    @Column
    private int now;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;
    @Column
    private Boolean state;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private  Date endTime;


    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }


    public Boolean getState()
    {
        return state;
    }


    public void setState(Boolean state)
    {
        this.state = state;
    }

    public Date getEndTime()
    {
        return endTime;
    }

    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }
}

