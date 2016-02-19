package com.entity_dao;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Finaproduct entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="finaproduct"
    ,catalog="bigdata"
)

public class Finaproduct  implements java.io.Serializable {


    // Fields    

     private Integer prodId;
     private String prodCode;
     private String prodName;
     private String prodDetail;
     private String riskLevel;
     private Date issueDate;
     private Double miniMoney;


    // Constructors

    /** default constructor */
    public Finaproduct() {
    }

    
    /** full constructor */
    public Finaproduct(String prodCode, String prodName, String prodDetail, String riskLevel, Date issueDate, Double miniMoney) {
        this.prodCode = prodCode;
        this.prodName = prodName;
        this.prodDetail = prodDetail;
        this.riskLevel = riskLevel;
        this.issueDate = issueDate;
        this.miniMoney = miniMoney;
    }

   
    // Property accessors
    @Id @GeneratedValue
    
    @Column(name="prod_id", unique=true, nullable=false)

    public Integer getProdId() {
        return this.prodId;
    }
    
    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }
    
    @Column(name="prod_code", length=50)

    public String getProdCode() {
        return this.prodCode;
    }
    
    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }
    
    @Column(name="prod_name", length=100)

    public String getProdName() {
        return this.prodName;
    }
    
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }
    
    @Column(name="prod_detail", length=1000)

    public String getProdDetail() {
        return this.prodDetail;
    }
    
    public void setProdDetail(String prodDetail) {
        this.prodDetail = prodDetail;
    }
    
    @Column(name="risk_level", length=50)

    public String getRiskLevel() {
        return this.riskLevel;
    }
    
    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="issue_date", length=10)

    public Date getIssueDate() {
        return this.issueDate;
    }
    
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
    
    @Column(name="mini_money", precision=10)

    public Double getMiniMoney() {
        return this.miniMoney;
    }
    
    public void setMiniMoney(Double miniMoney) {
        this.miniMoney = miniMoney;
    }
   








}