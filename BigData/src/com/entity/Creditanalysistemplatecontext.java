package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Creditanalysistemplatecontext entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="creditanalysistemplatecontext"
    ,catalog="bigdata"
)

public class Creditanalysistemplatecontext  implements java.io.Serializable {


    // Fields    

     private Integer templateId;
     private String generateRecordNum;
     private String maxSelectOwingTaxes;
     private String minSelectOwingTaxes;
     private String maxmElectricityArrears;
     private String minElectricityArrears;
     private String maxAdministrativerPunishment;
     private String minAdministrativerPunishment;
     private String maxEnforcement;
     private String minEnforcement;
     private String maxCivilJudgmentRecord;
     private String minCivilJudgmentRecord;
     private String maxOwingTaxes;
     private String minOwingTaxes;
     private String maxHouseLoan;
     private String minHouseLoan;
     private String maxLoansNum;
     private String minLoansNum;
     private String maxCreditNum;
     private String minCreditNum;
     private String maxMounthlyIncome;
     private String minMonthlyIncome;
     private String maxAge;
     private String minAge;


    // Constructors

    /** default constructor */
    public Creditanalysistemplatecontext() {
    }

    
    /** full constructor */
    public Creditanalysistemplatecontext(String generateRecordNum, String maxSelectOwingTaxes, String minSelectOwingTaxes, String maxmElectricityArrears, String minElectricityArrears, String maxAdministrativerPunishment, String minAdministrativerPunishment, String maxEnforcement, String minEnforcement, String maxCivilJudgmentRecord, String minCivilJudgmentRecord, String maxOwingTaxes, String minOwingTaxes, String maxHouseLoan, String minHouseLoan, String maxLoansNum, String minLoansNum, String maxCreditNum, String minCreditNum, String maxMounthlyIncome, String minMonthlyIncome, String maxAge, String minAge) {
        this.generateRecordNum = generateRecordNum;
        this.maxSelectOwingTaxes = maxSelectOwingTaxes;
        this.minSelectOwingTaxes = minSelectOwingTaxes;
        this.maxmElectricityArrears = maxmElectricityArrears;
        this.minElectricityArrears = minElectricityArrears;
        this.maxAdministrativerPunishment = maxAdministrativerPunishment;
        this.minAdministrativerPunishment = minAdministrativerPunishment;
        this.maxEnforcement = maxEnforcement;
        this.minEnforcement = minEnforcement;
        this.maxCivilJudgmentRecord = maxCivilJudgmentRecord;
        this.minCivilJudgmentRecord = minCivilJudgmentRecord;
        this.maxOwingTaxes = maxOwingTaxes;
        this.minOwingTaxes = minOwingTaxes;
        this.maxHouseLoan = maxHouseLoan;
        this.minHouseLoan = minHouseLoan;
        this.maxLoansNum = maxLoansNum;
        this.minLoansNum = minLoansNum;
        this.maxCreditNum = maxCreditNum;
        this.minCreditNum = minCreditNum;
        this.maxMounthlyIncome = maxMounthlyIncome;
        this.minMonthlyIncome = minMonthlyIncome;
        this.maxAge = maxAge;
        this.minAge = minAge;
    }

   
    // Property accessors
    @Id @GeneratedValue
    
    @Column(name="templateID", unique=true, nullable=false)

    public Integer getTemplateId() {
        return this.templateId;
    }
    
    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }
    
    @Column(name="GenerateRecordNum", length=50)

    public String getGenerateRecordNum() {
        return this.generateRecordNum;
    }
    
    public void setGenerateRecordNum(String generateRecordNum) {
        this.generateRecordNum = generateRecordNum;
    }
    
    @Column(name="maxSelectOwingTaxes", length=50)

    public String getMaxSelectOwingTaxes() {
        return this.maxSelectOwingTaxes;
    }
    
    public void setMaxSelectOwingTaxes(String maxSelectOwingTaxes) {
        this.maxSelectOwingTaxes = maxSelectOwingTaxes;
    }
    
    @Column(name="minSelectOwingTaxes", length=50)

    public String getMinSelectOwingTaxes() {
        return this.minSelectOwingTaxes;
    }
    
    public void setMinSelectOwingTaxes(String minSelectOwingTaxes) {
        this.minSelectOwingTaxes = minSelectOwingTaxes;
    }
    
    @Column(name="maxmElectricityArrears", length=50)

    public String getMaxmElectricityArrears() {
        return this.maxmElectricityArrears;
    }
    
    public void setMaxmElectricityArrears(String maxmElectricityArrears) {
        this.maxmElectricityArrears = maxmElectricityArrears;
    }
    
    @Column(name="minElectricityArrears", length=50)

    public String getMinElectricityArrears() {
        return this.minElectricityArrears;
    }
    
    public void setMinElectricityArrears(String minElectricityArrears) {
        this.minElectricityArrears = minElectricityArrears;
    }
    
    @Column(name="maxAdministrativerPunishment", length=50)

    public String getMaxAdministrativerPunishment() {
        return this.maxAdministrativerPunishment;
    }
    
    public void setMaxAdministrativerPunishment(String maxAdministrativerPunishment) {
        this.maxAdministrativerPunishment = maxAdministrativerPunishment;
    }
    
    @Column(name="minAdministrativerPunishment", length=50)

    public String getMinAdministrativerPunishment() {
        return this.minAdministrativerPunishment;
    }
    
    public void setMinAdministrativerPunishment(String minAdministrativerPunishment) {
        this.minAdministrativerPunishment = minAdministrativerPunishment;
    }
    
    @Column(name="maxEnforcement", length=50)

    public String getMaxEnforcement() {
        return this.maxEnforcement;
    }
    
    public void setMaxEnforcement(String maxEnforcement) {
        this.maxEnforcement = maxEnforcement;
    }
    
    @Column(name="minEnforcement", length=50)

    public String getMinEnforcement() {
        return this.minEnforcement;
    }
    
    public void setMinEnforcement(String minEnforcement) {
        this.minEnforcement = minEnforcement;
    }
    
    @Column(name="maxCivilJudgmentRecord", length=50)

    public String getMaxCivilJudgmentRecord() {
        return this.maxCivilJudgmentRecord;
    }
    
    public void setMaxCivilJudgmentRecord(String maxCivilJudgmentRecord) {
        this.maxCivilJudgmentRecord = maxCivilJudgmentRecord;
    }
    
    @Column(name="minCivilJudgmentRecord", length=50)

    public String getMinCivilJudgmentRecord() {
        return this.minCivilJudgmentRecord;
    }
    
    public void setMinCivilJudgmentRecord(String minCivilJudgmentRecord) {
        this.minCivilJudgmentRecord = minCivilJudgmentRecord;
    }
    
    @Column(name="maxOwingTaxes", length=50)

    public String getMaxOwingTaxes() {
        return this.maxOwingTaxes;
    }
    
    public void setMaxOwingTaxes(String maxOwingTaxes) {
        this.maxOwingTaxes = maxOwingTaxes;
    }
    
    @Column(name="minOwingTaxes", length=50)

    public String getMinOwingTaxes() {
        return this.minOwingTaxes;
    }
    
    public void setMinOwingTaxes(String minOwingTaxes) {
        this.minOwingTaxes = minOwingTaxes;
    }
    
    @Column(name="maxHouseLoan", length=50)

    public String getMaxHouseLoan() {
        return this.maxHouseLoan;
    }
    
    public void setMaxHouseLoan(String maxHouseLoan) {
        this.maxHouseLoan = maxHouseLoan;
    }
    
    @Column(name="minHouseLoan", length=50)

    public String getMinHouseLoan() {
        return this.minHouseLoan;
    }
    
    public void setMinHouseLoan(String minHouseLoan) {
        this.minHouseLoan = minHouseLoan;
    }
    
    @Column(name="maxLoansNum", length=50)

    public String getMaxLoansNum() {
        return this.maxLoansNum;
    }
    
    public void setMaxLoansNum(String maxLoansNum) {
        this.maxLoansNum = maxLoansNum;
    }
    
    @Column(name="minLoansNum", length=50)

    public String getMinLoansNum() {
        return this.minLoansNum;
    }
    
    public void setMinLoansNum(String minLoansNum) {
        this.minLoansNum = minLoansNum;
    }
    
    @Column(name="maxCreditNum", length=50)

    public String getMaxCreditNum() {
        return this.maxCreditNum;
    }
    
    public void setMaxCreditNum(String maxCreditNum) {
        this.maxCreditNum = maxCreditNum;
    }
    
    @Column(name="minCreditNum", length=50)

    public String getMinCreditNum() {
        return this.minCreditNum;
    }
    
    public void setMinCreditNum(String minCreditNum) {
        this.minCreditNum = minCreditNum;
    }
    
    @Column(name="maxMounthlyIncome", length=50)

    public String getMaxMounthlyIncome() {
        return this.maxMounthlyIncome;
    }
    
    public void setMaxMounthlyIncome(String maxMounthlyIncome) {
        this.maxMounthlyIncome = maxMounthlyIncome;
    }
    
    @Column(name="minMonthlyIncome", length=50)

    public String getMinMonthlyIncome() {
        return this.minMonthlyIncome;
    }
    
    public void setMinMonthlyIncome(String minMonthlyIncome) {
        this.minMonthlyIncome = minMonthlyIncome;
    }
    
    @Column(name="maxAge", length=50)

    public String getMaxAge() {
        return this.maxAge;
    }
    
    public void setMaxAge(String maxAge) {
        this.maxAge = maxAge;
    }
    
    @Column(name="minAge", length=50)

    public String getMinAge() {
        return this.minAge;
    }
    
    public void setMinAge(String minAge) {
        this.minAge = minAge;
    }
   








}