package com.zero.entitylib;

//个人信用简要信息

public class PersonalCredit {
    
	private String Id;  //编号
	private String PId; //身份Id
	private String Age; //年龄
	private String Level; //等级
	private String DetailInfo; //详细信息
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPId() {
		return PId;
	}
	public void setPId(String pId) {
		PId = pId;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getLevel() {
		return Level;
	}
	public void setLevel(String level) {
		Level = level;
	}
	public String getDetailInfo() {
		return DetailInfo;
	}
	public void setDetailInfo(String detailInfo) {
		DetailInfo = detailInfo;
	}
}
