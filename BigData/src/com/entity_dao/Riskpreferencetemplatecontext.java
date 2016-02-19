package com.entity_dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Riskpreferencetemplatecontext entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="riskpreferencetemplatecontext"
    ,catalog="bigdata"
)

public class Riskpreferencetemplatecontext  implements java.io.Serializable {


    // Fields    

     private Integer templateId;
     private String minAge;
     private String maxAge;
     private String minMonthlyIncome;
     private String maxMonthlyIncome;
     private String minProportionOfIncome;
     private String maxProportionOfIncome;
     private String minHistoricalInvestment;
     private String maxHistoricalInvestment;
     private String minHistoricalInvestmentScope;
     private String maxHistoricalInvestmentScope;
     private String minResidualScopeOfDeposit;
     private String maxResidualScopeOfDeposit;
     private String minListOfInvestmentProducts;
     private String maxListOfInvestmentProducts;
     private String minCustomerAgeRange;
     private String maxCustomerAgeRange;
     private String minCustomerIncomeRange;
     private String maxCustomerIncomeRange;
     private String minListOfCustomersIndustry;
     private String maxListOfCustomersIndustry;
     private String gerenalRecord;


    // Constructors

    /** default constructor */
    public Riskpreferencetemplatecontext() {
    }

    
    /** full constructor */
    public Riskpreferencetemplatecontext(String minAge, String maxAge, String minMonthlyIncome, String maxMonthlyIncome, String minProportionOfIncome, String maxProportionOfIncome, String minHistoricalInvestment, String maxHistoricalInvestment, String minHistoricalInvestmentScope, String maxHistoricalInvestmentScope, String minResidualScopeOfDeposit, String maxResidualScopeOfDeposit, String minListOfInvestmentProducts, String maxListOfInvestmentProducts, String minCustomerAgeRange, String maxCustomerAgeRange, String minCustomerIncomeRange, String maxCustomerIncomeRange, String minListOfCustomersIndustry, String maxListOfCustomersIndustry, String gerenalRecord) {
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.minMonthlyIncome = minMonthlyIncome;
        this.maxMonthlyIncome = maxMonthlyIncome;
        this.minProportionOfIncome = minProportionOfIncome;
        this.maxProportionOfIncome = maxProportionOfIncome;
        this.minHistoricalInvestment = minHistoricalInvestment;
        this.maxHistoricalInvestment = maxHistoricalInvestment;
        this.minHistoricalInvestmentScope = minHistoricalInvestmentScope;
        this.maxHistoricalInvestmentScope = maxHistoricalInvestmentScope;
        this.minResidualScopeOfDeposit = minResidualScopeOfDeposit;
        this.maxResidualScopeOfDeposit = maxResidualScopeOfDeposit;
        this.minListOfInvestmentProducts = minListOfInvestmentProducts;
        this.maxListOfInvestmentProducts = maxListOfInvestmentProducts;
        this.minCustomerAgeRange = minCustomerAgeRange;
        this.maxCustomerAgeRange = maxCustomerAgeRange;
        this.minCustomerIncomeRange = minCustomerIncomeRange;
        this.maxCustomerIncomeRange = maxCustomerIncomeRange;
        this.minListOfCustomersIndustry = minListOfCustomersIndustry;
        this.maxListOfCustomersIndustry = maxListOfCustomersIndustry;
        this.gerenalRecord = gerenalRecord;
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
    
    @Column(name="minAge", length=50)

    public String getMinAge() {
        return this.minAge;
    }
    
    public void setMinAge(String minAge) {
        this.minAge = minAge;
    }
    
    @Column(name="maxAge", length=50)

    public String getMaxAge() {
        return this.maxAge;
    }
    
    public void setMaxAge(String maxAge) {
        this.maxAge = maxAge;
    }
    
    @Column(name="minMonthlyIncome", length=50)

    public String getMinMonthlyIncome() {
        return this.minMonthlyIncome;
    }
    
    public void setMinMonthlyIncome(String minMonthlyIncome) {
        this.minMonthlyIncome = minMonthlyIncome;
    }
    
    @Column(name="maxMonthlyIncome", length=50)

    public String getMaxMonthlyIncome() {
        return this.maxMonthlyIncome;
    }
    
    public void setMaxMonthlyIncome(String maxMonthlyIncome) {
        this.maxMonthlyIncome = maxMonthlyIncome;
    }
    
    @Column(name="minProportionOfIncome", length=50)

    public String getMinProportionOfIncome() {
        return this.minProportionOfIncome;
    }
    
    public void setMinProportionOfIncome(String minProportionOfIncome) {
        this.minProportionOfIncome = minProportionOfIncome;
    }
    
    @Column(name="maxProportionOfIncome", length=50)

    public String getMaxProportionOfIncome() {
        return this.maxProportionOfIncome;
    }
    
    public void setMaxProportionOfIncome(String maxProportionOfIncome) {
        this.maxProportionOfIncome = maxProportionOfIncome;
    }
    
    @Column(name="minHistoricalInvestment", length=50)

    public String getMinHistoricalInvestment() {
        return this.minHistoricalInvestment;
    }
    
    public void setMinHistoricalInvestment(String minHistoricalInvestment) {
        this.minHistoricalInvestment = minHistoricalInvestment;
    }
    
    @Column(name="maxHistoricalInvestment", length=50)

    public String getMaxHistoricalInvestment() {
        return this.maxHistoricalInvestment;
    }
    
    public void setMaxHistoricalInvestment(String maxHistoricalInvestment) {
        this.maxHistoricalInvestment = maxHistoricalInvestment;
    }
    
    @Column(name="minHistoricalInvestmentScope", length=50)

    public String getMinHistoricalInvestmentScope() {
        return this.minHistoricalInvestmentScope;
    }
    
    public void setMinHistoricalInvestmentScope(String minHistoricalInvestmentScope) {
        this.minHistoricalInvestmentScope = minHistoricalInvestmentScope;
    }
    
    @Column(name="maxHistoricalInvestmentScope", length=50)

    public String getMaxHistoricalInvestmentScope() {
        return this.maxHistoricalInvestmentScope;
    }
    
    public void setMaxHistoricalInvestmentScope(String maxHistoricalInvestmentScope) {
        this.maxHistoricalInvestmentScope = maxHistoricalInvestmentScope;
    }
    
    @Column(name="minResidualScopeOfDeposit", length=50)

    public String getMinResidualScopeOfDeposit() {
        return this.minResidualScopeOfDeposit;
    }
    
    public void setMinResidualScopeOfDeposit(String minResidualScopeOfDeposit) {
        this.minResidualScopeOfDeposit = minResidualScopeOfDeposit;
    }
    
    @Column(name="maxResidualScopeOfDeposit", length=50)

    public String getMaxResidualScopeOfDeposit() {
        return this.maxResidualScopeOfDeposit;
    }
    
    public void setMaxResidualScopeOfDeposit(String maxResidualScopeOfDeposit) {
        this.maxResidualScopeOfDeposit = maxResidualScopeOfDeposit;
    }
    
    @Column(name="minListOfInvestmentProducts", length=50)

    public String getMinListOfInvestmentProducts() {
        return this.minListOfInvestmentProducts;
    }
    
    public void setMinListOfInvestmentProducts(String minListOfInvestmentProducts) {
        this.minListOfInvestmentProducts = minListOfInvestmentProducts;
    }
    
    @Column(name="maxListOfInvestmentProducts", length=50)

    public String getMaxListOfInvestmentProducts() {
        return this.maxListOfInvestmentProducts;
    }
    
    public void setMaxListOfInvestmentProducts(String maxListOfInvestmentProducts) {
        this.maxListOfInvestmentProducts = maxListOfInvestmentProducts;
    }
    
    @Column(name="minCustomerAgeRange", length=50)

    public String getMinCustomerAgeRange() {
        return this.minCustomerAgeRange;
    }
    
    public void setMinCustomerAgeRange(String minCustomerAgeRange) {
        this.minCustomerAgeRange = minCustomerAgeRange;
    }
    
    @Column(name="maxCustomerAgeRange", length=50)

    public String getMaxCustomerAgeRange() {
        return this.maxCustomerAgeRange;
    }
    
    public void setMaxCustomerAgeRange(String maxCustomerAgeRange) {
        this.maxCustomerAgeRange = maxCustomerAgeRange;
    }
    
    @Column(name="minCustomerIncomeRange", length=50)

    public String getMinCustomerIncomeRange() {
        return this.minCustomerIncomeRange;
    }
    
    public void setMinCustomerIncomeRange(String minCustomerIncomeRange) {
        this.minCustomerIncomeRange = minCustomerIncomeRange;
    }
    
    @Column(name="maxCustomerIncomeRange", length=50)

    public String getMaxCustomerIncomeRange() {
        return this.maxCustomerIncomeRange;
    }
    
    public void setMaxCustomerIncomeRange(String maxCustomerIncomeRange) {
        this.maxCustomerIncomeRange = maxCustomerIncomeRange;
    }
    
    @Column(name="minListOfCustomersIndustry", length=50)

    public String getMinListOfCustomersIndustry() {
        return this.minListOfCustomersIndustry;
    }
    
    public void setMinListOfCustomersIndustry(String minListOfCustomersIndustry) {
        this.minListOfCustomersIndustry = minListOfCustomersIndustry;
    }
    
    @Column(name="maxListOfCustomersIndustry", length=50)

    public String getMaxListOfCustomersIndustry() {
        return this.maxListOfCustomersIndustry;
    }
    
    public void setMaxListOfCustomersIndustry(String maxListOfCustomersIndustry) {
        this.maxListOfCustomersIndustry = maxListOfCustomersIndustry;
    }
    
    @Column(name="gerenalRecord", length=50)

    public String getGerenalRecord() {
        return this.gerenalRecord;
    }
    
    public void setGerenalRecord(String gerenalRecord) {
        this.gerenalRecord = gerenalRecord;
    }
   








}