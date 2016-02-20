package com.entity;



public class InvestTemplateAllInfo {
	private long id;// 编号
	private InvestTemplateContext investTemplateContext;
	private String generateNums;// 生成数量
	private Adminuser createUser;// 创建模板用户
	private Adminuser useUser;// 使用用户
	private String time;// 创建或使用

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public InvestTemplateContext getInvestTemplateContext() {
		return investTemplateContext;
	}

	public void setInvestTemplateContext(
			InvestTemplateContext investTemplateContext) {
		this.investTemplateContext = investTemplateContext;
	}

	public String getGenerateNums() {
		return generateNums;
	}

	public void setGenerateNums(String generateNums) {
		this.generateNums = generateNums;
	}

	public Adminuser getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Adminuser createUser) {
		this.createUser = createUser;
	}

	public Adminuser getUseUser() {
		return useUser;
	}

	public void setUseUser(Adminuser useUser) {
		this.useUser = useUser;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
