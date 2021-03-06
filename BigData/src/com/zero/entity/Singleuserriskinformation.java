package com.zero.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Singleuserriskinformation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="singleuserriskinformation")

public class Singleuserriskinformation  implements java.io.Serializable {


    // Fields    
	private int singleuserinfoId;
     private String userId;
     private String username;
     private String age;
     private String monthlyIncome;
     private String proportionOfIncome;
     private String historicalInvestment;
     private String historicalInvestmentScope;
     private String residualScopeOfDeposit;
     private String listOfInvestmentProducts;
     private String customerAgeRange;
     private String customerIncomeRange;
     private String listOfCustomersIndustry;


    // Constructors

    /** default constructor */
    public Singleuserriskinformation() {
    }

    
    /** full constructor */
    public Singleuserriskinformation(String userId,String username, String age, String monthlyIncome, String proportionOfIncome, String historicalInvestment, String historicalInvestmentScope, String residualScopeOfDeposit, String listOfInvestmentProducts, String customerAgeRange, String customerIncomeRange, String listOfCustomersIndustry) {
        this.userId=userId;
    	this.username = username;
        this.age = age;
        this.monthlyIncome = monthlyIncome;
        this.proportionOfIncome = proportionOfIncome;
        this.historicalInvestment = historicalInvestment;
        this.historicalInvestmentScope = historicalInvestmentScope;
        this.residualScopeOfDeposit = residualScopeOfDeposit;
        this.listOfInvestmentProducts = listOfInvestmentProducts;
        this.customerAgeRange = customerAgeRange;
        this.customerIncomeRange = customerIncomeRange;
        this.listOfCustomersIndustry = listOfCustomersIndustry;
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
    
    @Column(name="username", length=50)

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name="age", length=50)

    public String getAge() {
        return this.age;
    }
    
    public void setAge(String age) {
        this.age = age;
    }
    
    @Column(name="monthlyIncome", length=50)

    public String getMonthlyIncome() {
        return this.monthlyIncome;
    }
    
    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }
    
    @Column(name="proportionOfIncome", length=50)

    public String getProportionOfIncome() {
        return this.proportionOfIncome;
    }
    
    public void setProportionOfIncome(String proportionOfIncome) {
        this.proportionOfIncome = proportionOfIncome;
    }
    
    @Column(name="historicalInvestment", length=50)

    public String getHistoricalInvestment() {
        return this.historicalInvestment;
    }
    
    public void setHistoricalInvestment(String historicalInvestment) {
        this.historicalInvestment = historicalInvestment;
    }
    
    @Column(name="historicalInvestmentScope", length=50)

    public String getHistoricalInvestmentScope() {
        return this.historicalInvestmentScope;
    }
    
    public void setHistoricalInvestmentScope(String historicalInvestmentScope) {
        this.historicalInvestmentScope = historicalInvestmentScope;
    }
    
    @Column(name="residualScopeOfDeposit", length=50)

    public String getResidualScopeOfDeposit() {
        return this.residualScopeOfDeposit;
    }
    
    public void setResidualScopeOfDeposit(String residualScopeOfDeposit) {
        this.residualScopeOfDeposit = residualScopeOfDeposit;
    }
    
    @Column(name="listOfInvestmentProducts", length=50)

    public String getListOfInvestmentProducts() {
        return this.listOfInvestmentProducts;
    }
    
    public void setListOfInvestmentProducts(String listOfInvestmentProducts) {
        this.listOfInvestmentProducts = listOfInvestmentProducts;
    }
    
    @Column(name="customerAgeRange", length=50)

    public String getCustomerAgeRange() {
        return this.customerAgeRange;
    }
    
    public void setCustomerAgeRange(String customerAgeRange) {
        this.customerAgeRange = customerAgeRange;
    }
    
    @Column(name="customerIncomeRange", length=50)

    public String getCustomerIncomeRange() {
        return this.customerIncomeRange;
    }
    
    public void setCustomerIncomeRange(String customerIncomeRange) {
        this.customerIncomeRange = customerIncomeRange;
    }
    
    @Column(name="listOfCustomersIndustry", length=50)

    public String getListOfCustomersIndustry() {
        return this.listOfCustomersIndustry;
    }
    
    public void setListOfCustomersIndustry(String listOfCustomersIndustry) {
        this.listOfCustomersIndustry = listOfCustomersIndustry;
    }
   








}