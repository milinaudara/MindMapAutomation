package com.automindmap.actions.map;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;



import com.automindmap.logics.OutputProcessor;
import com.automindmap.models.MindMapView.MindMapViewModel;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("json-default")
@Result(type = "json")
public class TestProcess extends ActionSupport {

	private String mindmap;
	

	@Override
	public String execute() throws Exception {
		OutputProcessor output=new OutputProcessor();
	MindMapViewModel map=output.getOutput(1);
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

	
}
