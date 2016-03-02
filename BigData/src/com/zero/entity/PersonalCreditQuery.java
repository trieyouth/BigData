package com.zero.entity;

public class PersonalCreditQuery {
	private int minAge;//v14
	private int minMonthlyIncome;//v9/12
	private int minWorkYears;//v20/12
	private int minCreditNum;//v50
	private int minLoansNum;//v37
	private int minLoansAmount;//v38
	private int minApplyForLoanNum;//v24
	
	private int maxAge;
	private int maxMonthlyIncome;
	private int maxWorkYears;
	private int maxCreditNum;
	private int maxLoansNum;
	private int maxLoansAmount;
	private int maxApplyForLoanNum;
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	public int getMinMonthlyIncome() {
		return minMonthlyIncome;
	}
	public void setMinMonthlyIncome(int minMonthlyIncome) {
		this.minMonthlyIncome = minMonthlyIncome;
	}
	public int getMinWorkYears() {
		return minWorkYears;
	}
	public void setMinWorkYears(int minWorkYears) {
		this.minWorkYears = minWorkYears;
	}
	public int getMinCreditNum() {
		return minCreditNum;
	}
	public void setMinCreditNum(int minCreditNum) {
		this.minCreditNum = minCreditNum;
	}
	public int getMinLoansNum() {
		return minLoansNum;
	}
	public void setMinLoansNum(int minLoansNum) {
		this.minLoansNum = minLoansNum;
	}
	public int getMinLoansAmount() {
		return minLoansAmount;
	}
	public void setMinLoansAmount(int minLoansAmount) {
		this.minLoansAmount = minLoansAmount;
	}
	public int getMinApplyForLoanNum() {
		return minApplyForLoanNum;
	}
	public void setMinApplyForLoanNum(int minApplyForLoanNum) {
		this.minApplyForLoanNum = minApplyForLoanNum;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public int getMaxMonthlyIncome() {
		return maxMonthlyIncome;
	}
	public void setMaxMonthlyIncome(int maxMonthlyIncome) {
		this.maxMonthlyIncome = maxMonthlyIncome;
	}
	public int getMaxWorkYears() {
		return maxWorkYears;
	}
	public void setMaxWorkYears(int maxWorkYears) {
		this.maxWorkYears = maxWorkYears;
	}
	public int getMaxCreditNum() {
		return maxCreditNum;
	}
	public void setMaxCreditNum(int maxCreditNum) {
		this.maxCreditNum = maxCreditNum;
	}
	public int getMaxLoansNum() {
		return maxLoansNum;
	}
	public void setMaxLoansNum(int maxLoansNum) {
		this.maxLoansNum = maxLoansNum;
	}
	public int getMaxLoansAmount() {
		return maxLoansAmount;
	}
	public void setMaxLoansAmount(int maxLoansAmount) {
		this.maxLoansAmount = maxLoansAmount;
	}
	public int getMaxApplyForLoanNum() {
		return maxApplyForLoanNum;
	}
	public void setMaxApplyForLoanNum(int maxApplyForLoanNum) {
		this.maxApplyForLoanNum = maxApplyForLoanNum;
	}
	public PersonalCreditQuery(int minAge, int minMonthlyIncome,
			int minWorkYears, int minCreditNum, int minLoansNum,
			int minLoansAmount, int minApplyForLoanNum, int maxAge,
			int maxMonthlyIncome, int maxWorkYears, int maxCreditNum,
			int maxLoansNum, int maxLoansAmount, int maxApplyForLoanNum) {
		super();
		this.minAge = minAge;
		this.minMonthlyIncome = minMonthlyIncome;
		this.minWorkYears = minWorkYears;
		this.minCreditNum = minCreditNum;
		this.minLoansNum = minLoansNum;
		this.minLoansAmount = minLoansAmount;
		this.minApplyForLoanNum = minApplyForLoanNum;
		this.maxAge = maxAge;
		this.maxMonthlyIncome = maxMonthlyIncome;
		this.maxWorkYears = maxWorkYears;
		this.maxCreditNum = maxCreditNum;
		this.maxLoansNum = maxLoansNum;
		this.maxLoansAmount = maxLoansAmount;
		this.maxApplyForLoanNum = maxApplyForLoanNum;
	}
	public PersonalCreditQuery() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
