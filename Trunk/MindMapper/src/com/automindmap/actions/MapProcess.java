package com.automindmap.actions;


import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.automindmap.logics.InputProcessor;
import com.opensymphony.xwork2.ActionSupport;;

@ParentPackage("json-default")
@Result(type = "json")
public class MapProcess extends ActionSupport {


	private String mapId;
	private String inputText;

	
	    public String action1() {
	        return ActionSupport.SUCCESS;
	    }
	@Override
	public String execute() throws Exception {
		
		InputProcessor inputprocess= new InputProcessor();
		inputprocess.mainProcess(new Integer(mapId),1,inputText);
		return "success";
	}
	
	public String getMapId() {
		return mapId;
	}
	public void setMapId(String mapId) {
		this.mapId = mapId;
	}
	public String getInputText() {
		return inputText;
	}
	public void setInputText(String inputText) {
		this.inputText = inputText;
	}

}
