package com.entity_dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Authority entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="authority"
    ,catalog="bigdata"
)

public class Authority  implements java.io.Serializable {


    // Fields    

     private Integer authId;
     private String authName;


    // Constructors

    /** default constructor */
    public Authority() {
    }

    
    /** full constructor */
    public Authority(String authName) {
        this.authName = authName;
    }

   
    // Property accessors
    @Id @GeneratedValue
    
    @Column(name="auth_id", unique=true, nullable=false)

    public Integer getAuthId() {
        return this.authId;
    }
    
    public void setAuthId(Integer authId) {
        this.authId = authId;
    }
    
    @Column(name="auth_name", length=100)

    public String getAuthName() {
        return this.authName;
    }
    
    public void setAuthName(String authName) {
        this.authName = authName;
    }
   








}