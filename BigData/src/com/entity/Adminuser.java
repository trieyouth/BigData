package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Adminuser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="adminuser")

public class Adminuser  implements java.io.Serializable {


    // Fields    

     private Integer adminId;
     private String adminName;
     private String adminTitle;
     private String adminPasswd;


    // Constructors

    /** default constructor */
    public Adminuser() {
    }

    
    /** full constructor */
    public Adminuser(String adminName, String adminTitle, String adminPasswd) {
        this.adminName = adminName;
        this.adminTitle = adminTitle;
        this.adminPasswd = adminPasswd;
    }

   
    // Property accessors
    @Id @GeneratedValue
    
    @Column(name="admin_id", unique=true, nullable=false)

    public Integer getAdminId() {
        return this.adminId;
    }
    
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
    
    @Column(name="admin_name", length=50)

    public String getAdminName() {
        return this.adminName;
    }
    
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    
    @Column(name="admin_title", length=100)

    public String getAdminTitle() {
        return this.adminTitle;
    }
    
    public void setAdminTitle(String adminTitle) {
        this.adminTitle = adminTitle;
    }
    
    @Column(name="admin_passwd", length=50)

    public String getAdminPasswd() {
        return this.adminPasswd;
    }
    
    public void setAdminPasswd(String adminPasswd) {
        this.adminPasswd = adminPasswd;
    }
   








}