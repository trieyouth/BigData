package com.zero.entity;

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
 * Templatedata entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="templatedata")

public class Templatedata  implements java.io.Serializable {


    // Fields    

     private Integer tempId;
     private Integer adminId;
     private Date tempDate;
     private Time tempTime;


    // Constructors

    /** default constructor */
    public Templatedata() {
    }

	/** minimal constructor */
    public Templatedata(Integer adminId) {
        this.adminId = adminId;
    }
    
    /** full constructor */
    public Templatedata(Integer adminId, Date tempDate, Time tempTime) {
        this.adminId = adminId;
        this.tempDate = tempDate;
        this.tempTime = tempTime;
    }

   
    // Property accessors
    @Id @GeneratedValue
    
    @Column(name="temp_id", unique=true, nullable=false)

    public Integer getTempId() {
        return this.tempId;
    }
    
    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }
    
    @Column(name="admin_id", nullable=false)

    public Integer getAdminId() {
        return this.adminId;
    }
    
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="temp_date", length=10)

    public Date getTempDate() {
        return this.tempDate;
    }
    
    public void setTempDate(Date tempDate) {
        this.tempDate = tempDate;
    }
    
    @Column(name="temp_time", length=8)

    public Time getTempTime() {
        return this.tempTime;
    }
    
    public void setTempTime(Time tempTime) {
        this.tempTime = tempTime;
    }
   








}