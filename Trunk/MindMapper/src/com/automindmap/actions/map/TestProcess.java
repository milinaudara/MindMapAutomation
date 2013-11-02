package com.automindmap.actions.map;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;



import com.automindmap.logics.InputProcessor;
import com.automindmap.logics.OutputProcessor;
import com.automindmap.models.MindMapView.MindMapViewModel;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("json-default")
@Result(type = "json")
public class TestProcess extends ActionSupport {
	
	private String mapId;
	private String inputText;
	private String mindmap;
	

	@Override
	public String execute() throws Exception {
		
	InputProcessor inputprocess= new InputProcessor();
	if(mapId!=null && inputText!=null){
	inputprocess.mainProcess(new Integer(mapId),2,inputText);
	}
		
	OutputProcessor output=new OutputProcessor();
	MindMapViewModel map=output.getOutput(2);
	List<MindMapViewModel> listmap=new ArrayList<MindMapViewModel>();
		listmap.add(map);
	Gson gson = new Gson();
	//to get json object use toJson
	String json = gson.toJson(map);
	json=json.replace("\\", "");
		  setMindmap(json);

		return "success";
	}

	public String getMindmap() {
		return mindmap;
	}

	public void setMindmap(String mindmap) {
		this.mindmap = mindmap;
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
