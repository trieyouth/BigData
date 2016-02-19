package com.entity;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Logweb entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="logweb")

public class Logweb  implements java.io.Serializable {


    // Fields    

     private Long logId;
     private Integer adminId;
     private String logConten;
     private Date logDate;
     private Time logTime;


    // Constructors

    /** default constructor */
    public Logweb() {
    }

    
    /** full constructor */
    public Logweb(Integer adminId, String logConten, Date logDate, Time logTime) {
        this.adminId = adminId;
        this.logConten = logConten;
        this.logDate = logDate;
        this.logTime = logTime;
    }

   
    // Property accessors
    @Id @GeneratedValue
    
    @Column(name="log_id", unique=true, nullable=false)

    public Long getLogId() {
        return this.logId;
    }
    
    public void setLogId(Long logId) {
        this.logId = logId;
    }
    
    @Column(name="admin_id")

    public Integer getAdminId() {
        return this.adminId;
    }
    
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
    
    @Column(name="log_conten", length=1024)

    public String getLogConten() {
        return this.logConten;
    }
    
    public void setLogConten(String logConten) {
        this.logConten = logConten;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="log_date", length=10)

    public Date getLogDate() {
        return this.logDate;
    }
    
    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }
    
    @Column(name="log_time", length=8)

    public Time getLogTime() {
        return this.logTime;
    }
    
    public void setLogTime(Time logTime) {
        this.logTime = logTime;
    }
   








}