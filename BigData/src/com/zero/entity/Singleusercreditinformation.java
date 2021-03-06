package com.zero.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Singleusercreditinformation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="singleusercreditinformation")

public class Singleusercreditinformation  implements java.io.Serializable {


    // Fields    
	private int singleuserinfoId;
	private String userId;
	private String userName;
	private String generateRecordNum;
	private String selectOwingTaxes;
	private String electricityArrears;
	private String administrativerPunishment;
	private String enforcement;
	private String civilJudgmentRecord;
	private String owingTaxes;
	private String houseLoan;
	private String loansNum;
	private String creditNum;
	private String monthlyIncome;
	private String age;


    // Constructors

    /** default constructor */
    public Singleusercreditinformation() {
    }

    
    /** full constructor */
    public Singleusercreditinformation(String userId,String userName, String generateRecordNum, String selectOwingTaxes, String electricityArrears, String administrativerPunishment, String enforcement, String civilJudgmentRecord, String owingTaxes, String houseLoan, String loansNum, String creditNum, String monthlyIncome, String age) {
    	this.userId=userId;
    	this.userName = userName;
        this.generateRecordNum = generateRecordNum;
        this.selectOwingTaxes = selectOwingTaxes;
        this.electricityArrears = electricityArrears;
        this.administrativerPunishment = administrativerPunishment;
        this.enforcement = enforcement;
        this.civilJudgmentRecord = civilJudgmentRecord;
        this.owingTaxes = owingTaxes;
        this.houseLoan = houseLoan;
        this.loansNum = loansNum;
        this.creditNum = creditNum;
        this.monthlyIncome = monthlyIncome;
        this.age = age;
    }

   
    // Property accessors
    @Id @GeneratedValue
    
    @Column(name="singleuserinfoID", unique=true, nullable=false)

    public int getSingleuserinfoId() {
		return singleuserinfoId;
	}
    public void setSingleuserinfoId(int singleuserinfoId) {
        this.singleuserinfoId = singleuserinfoId;
    }
    @Column(name="userID", length=50)
    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    @Column(name="userName", length=50)

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    @Column(name="generateRecordNum", length=50)

    public String getGenerateRecordNum() {
        return this.generateRecordNum;
    }
    
    public void setGenerateRecordNum(String generateRecordNum) {
        this.generateRecordNum = generateRecordNum;
    }
    
    @Column(name="selectOwingTaxes", length=50)

    public String getSelectOwingTaxes() {
        return this.selectOwingTaxes;
    }
    
    public void setSelectOwingTaxes(String selectOwingTaxes) {
        this.selectOwingTaxes = selectOwingTaxes;
    }
    
    @Column(name="electricityArrears", length=50)

    public String getElectricityArrears() {
        return this.electricityArrears;
    }
    
    public void setElectricityArrears(String electricityArrears) {
        this.electricityArrears = electricityArrears;
    }
    
    @Column(name="administrativerPunishment", length=50)

    public String getAdministrativerPunishment() {
        return this.administrativerPunishment;
    }
    
    public void setAdministrativerPunishment(String administrativerPunishment) {
        this.administrativerPunishment = administrativerPunishment;
    }
    
    @Column(name="enforcement", length=50)

    public String getEnforcement() {
        return this.enforcement;
    }
    
    public void setEnforcement(String enforcement) {
        this.enforcement = enforcement;
    }
    
    @Column(name="civilJudgmentRecord", length=50)

    public String getCivilJudgmentRecord() {
        return this.civilJudgmentRecord;
    }
    
    public void setCivilJudgmentRecord(String civilJudgmentRecord) {
        this.civilJudgmentRecord = civilJudgmentRecord;
    }
    
    @Column(name="owingTaxes", length=50)

    public String getOwingTaxes() {
        return this.owingTaxes;
    }
    
    public void setOwingTaxes(String owingTaxes) {
        this.owingTaxes = owingTaxes;
    }
    
    @Column(name="houseLoan", length=50)

    public String getHouseLoan() {
        return this.houseLoan;
    }
    
    public void setHouseLoan(String houseLoan) {
        this.houseLoan = houseLoan;
    }
    
    @Column(name="loansNum", length=50)

    public String getLoansNum() {
        return this.loansNum;
    }
    
    public void setLoansNum(String loansNum) {
        this.loansNum = loansNum;
    }
    
    @Column(name="creditNum", length=50)

    public String getCreditNum() {
        return this.creditNum;
    }
    
    public void setCreditNum(String creditNum) {
        this.creditNum = creditNum;
    }
    
    @Column(name="monthlyIncome", length=50)

    public String getMonthlyIncome() {
        return this.monthlyIncome;
    }
    
    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }
    
    @Column(name="age", length=50)

    public String getAge() {
        return this.age;
    }
    
    public void setAge(String age) {
        this.age = age;
    }
   








}