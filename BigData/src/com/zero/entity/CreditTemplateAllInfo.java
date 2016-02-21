package com.zero.entity;

/**
 * 记录模板的所有信息
 * 
 * @author WangHong
 * 
 */
public class CreditTemplateAllInfo {
	private String id;// 编号
	private CreditTemplateContext creditTemplateContext;
	private String generateNums;// 生成数量
	private Adminuser createUser;// 创建模板用户
	private Adminuser useUser;// 使用用户
	private String time;// 创建或使用
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public CreditTemplateContext getCreditTemplateContext() {
		return creditTemplateContext;
	}
	public void setCreditTemplateContext(CreditTemplateContext creditTemplateContext) {
		this.creditTemplateContext = creditTemplateContext;
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
