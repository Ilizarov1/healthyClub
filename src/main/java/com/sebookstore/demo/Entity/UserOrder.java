package com.sebookstore.demo.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class UserOrder implements Serializable
{
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long userId;

    public boolean isState() {
        return state;
    }

    @Column
    private Long healthyitemId;
    @Column
    private String jsName;
    @Column
    private long jsId;

    public long getJsId() {
        return jsId;
    }

    public void setJsId(long jsId) {
        this.jsId = jsId;
    }

    @Column
    private String healthyitemName;
    @Column
    private String type;



    @Column
    private boolean state;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    public void setState(boolean state) {
        this.state = state;
    }
    public boolean getState() {
        return this.state;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getHealthyitemId() {
        return healthyitemId;
    }

    public void setHealthyitemId(Long healthyitemId) {
        this.healthyitemId = healthyitemId;
    }


    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }

    public Date getStartTime()
    {
        return startTime;
    }

    public String getHealthyitemName()
    {
        return healthyitemName;
    }

    public String getJsName()
    {
        return jsName;
    }

    public String getType()
    {
        return type;
    }

    public void setHealthyitemName(String healthyitemName)
    {
        this.healthyitemName = healthyitemName;
    }

    public void setJsName(String jsName)
    {
        this.jsName = jsName;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
