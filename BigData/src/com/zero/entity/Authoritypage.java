package com.zero.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Authoritypage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="authoritypage")

public class Authoritypage  implements java.io.Serializable {


    // Fields    

     private Integer pageId;
     private Integer authId;
     private String pageUrl;
     private String pageName;


    // Constructors

    /** default constructor */
    public Authoritypage() {
    }

	/** minimal constructor */
    public Authoritypage(String pageUrl) {
        this.pageUrl = pageUrl;
    }
    
    /** full constructor */
    public Authoritypage(Integer authId, String pageUrl, String pageName) {
        this.authId = authId;
        this.pageUrl = pageUrl;
        this.pageName = pageName;
    }

   
    // Property accessors
    @Id @GeneratedValue
    
    @Column(name="page_id", unique=true, nullable=false)

    public Integer getPageId() {
        return this.pageId;
    }
    
    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }
    
    @Column(name="auth_id")

    public Integer getAuthId() {
        return this.authId;
    }
    
    public void setAuthId(Integer authId) {
        this.authId = authId;
    }
    
    @Column(name="page_url", nullable=false, length=100)

    public String getPageUrl() {
        return this.pageUrl;
    }
    
    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }
    
    @Column(name="page_name", length=100)

    public String getPageName() {
        return this.pageName;
    }
    
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
   
}