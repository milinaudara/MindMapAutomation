package com.automindmap.actions;


import com.opensymphony.xwork2.Action;


public class MapAction implements Action {

	private String greeting;

	@Override
	public String execute() throws Exception {

	
		return "success";
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

}
