package com.zero.entity;

import java.sql.Time;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Templateuser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="templateuser")

public class Templateuser  implements java.io.Serializable {


    // Fields    

     private TemplateuserId id;
     private Date useDate;
     private Time useTime;
     private Long dataNumber;


    // Constructors

    /** default constructor */
    public Templateuser() {
    }

	/** minimal constructor */
    public Templateuser(TemplateuserId id) {
        this.id = id;
    }
    
    /** full constructor */
    public Templateuser(TemplateuserId id, Date useDate, Time useTime, Long dataNumber) {
        this.id = id;
        this.useDate = useDate;
        this.useTime = useTime;
        this.dataNumber = dataNumber;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="adminId", column=@Column(name="admin_id", nullable=false) ), 
        @AttributeOverride(name="tempId", column=@Column(name="temp_id", nullable=false) ) } )

    public TemplateuserId getId() {
        return this.id;
    }
    
    public void setId(TemplateuserId id) {
        this.id = id;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="use_date", length=10)

    public Date getUseDate() {
        return this.useDate;
    }
    
    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }
    
    @Column(name="use_time", length=8)

    public Time getUseTime() {
        return this.useTime;
    }
    
    public void setUseTime(Time useTime) {
        this.useTime = useTime;
    }
    
    @Column(name="data_number")

    public Long getDataNumber() {
        return this.dataNumber;
    }
    
    public void setDataNumber(Long dataNumber) {
        this.dataNumber = dataNumber;
    }
   








}