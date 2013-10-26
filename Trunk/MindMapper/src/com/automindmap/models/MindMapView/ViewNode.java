package com.automindmap.models.MindMapView;

import java.util.List;

public class ViewNode {

	public int id;
	public String parentId;
	public Text text;
	public Dimensions offset;
	public Boolean foldChildren;
	public String branchColor;
	public List<ViewNode> children;
}
