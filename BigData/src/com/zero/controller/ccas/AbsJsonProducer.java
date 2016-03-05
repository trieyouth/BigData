package com.zero.controller.ccas;

public abstract class AbsJsonProducer implements JsonProducer{
	
	protected String type;
	
	public AbsJsonProducer(String type){
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
	
	public void serType(String type){
		this.type = type;
	}

}
