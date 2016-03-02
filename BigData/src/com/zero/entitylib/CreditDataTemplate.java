package com.zero.entitylib;

//客户信用分析系统
//生成数据模板管理
//字段【编号】、【创建时间】、【生成数量】、【创建人】、【详细信息】、【使用信息】

public class CreditDataTemplate {

	private String Id; // 编号
	private String GenerateTime; // 创建时间
	private String GenerateSum; // 生成数量
	private String Creator; // 创建人
	private String DetailInformation; // 详细信息
	private String UseInformation; // 使用信息

	public CreditDataTemplate() {

	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getGenerateTime() {
		return GenerateTime;
	}

	public void setGenerateTime(String generateTime) {
		GenerateTime = generateTime;
	}

	public String getGenerateSum() {
		return GenerateSum;
	}

	public void setGenerateSum(String generateSum) {
		GenerateSum = generateSum;
	}

	public String getCreator() {
		return Creator;
	}

	public void setCreator(String creator) {
		Creator = creator;
	}

	public String getDetailInformation() {
		return DetailInformation;
	}

	public void setDetailInformation(String detailInformation) {
		DetailInformation = detailInformation;
	}

	public String getUseInformation() {
		return UseInformation;
	}

	public void setUseInformation(String useInformation) {
		UseInformation = useInformation;
	}

}
