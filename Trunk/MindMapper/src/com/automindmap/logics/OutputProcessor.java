package com.automindmap.logics;

import java.util.ArrayList;
import java.util.List;

import com.automindmap.models.Node;
import com.automindmap.models.MindMapView.Dates;
import com.automindmap.models.MindMapView.Dimensions;
import com.automindmap.models.MindMapView.Font;
import com.automindmap.models.MindMapView.MindMap;
import com.automindmap.models.MindMapView.MindMapViewModel;
import com.automindmap.models.MindMapView.Text;
import com.automindmap.models.MindMapView.ViewNode;
import com.automindmap.repositories.UnitOfWork;

public class OutputProcessor {
	
	UnitOfWork _unitofwork= new UnitOfWork();
	
	 public MindMapViewModel	getOutput(int mapId) {
		MindMapViewModel mapViewModel= new MindMapViewModel();
		
		Node parantNode=_unitofwork.node.getPerantNode(mapId);
		
		
		mapViewModel.id=mapId;
		mapViewModel.title=parantNode.value;
		mapViewModel.dates=getDates();
		mapViewModel.dimensions=getParentDimensions();
		mapViewModel.mindmap=getMindMap(parantNode);
		
		return mapViewModel;
	}

	 private MindMap getMindMap(Node parantNode) {
		MindMap mindMap=new MindMap();
		mindMap.root=getRootNode(parantNode);
		 
		return mindMap;
	}

	private ViewNode getRootNode(Node parantNode) {
		ViewNode root=new ViewNode();
		root.id=parantNode.id;
		root.parentId=null;
		root.text=getText(parantNode.value);
		root.offset=getOffset(0,0);	
		root.foldChildren=false;
		root.branchColor="#000000";
		root.children=getChildren(parantNode.id);
		return root;
	}
	
	private List<ViewNode> getChildren(int id) {
		List<ViewNode> childrenList= new ArrayList<ViewNode>();
		List<Node> nodeList=_unitofwork.node.getChildNodes(id);
		for (int i = 0; i < nodeList.size(); i++) {	
			if(i==0){
			childrenList.add(getNode(nodeList.get(i),"#83f572", 0	, 150));
			}
			else if(i==1){
				childrenList.add(getNode(nodeList.get(i),"#83f572", 150	, 0));
				}
			else if(i==2){
				childrenList.add(getNode(nodeList.get(i),"#83f572", 0	, -150));
				}
			else if(i==3){
					childrenList.add(getNode(nodeList.get(i),"#83f572", -150	, 0));
					}
			
		}
			
		
		return childrenList;
	}

	private ViewNode getNode(Node parantNode,String bramchColor,int x,int y) {
		ViewNode node=new ViewNode();
		node.id=parantNode.id;
		node.parentId=null;
		node.text=getText(parantNode.value);
		node.offset=getOffset(x,y);	
		node.foldChildren=false;
		node.branchColor=bramchColor;
		node.children=getChildren(parantNode.id);
		return node;
	}
	
	private Dimensions getOffset(int x, int y) {
	Dimensions offset= new Dimensions();
	offset.x=x;
	offset.y=y;
	
		return offset;
	}

	private Text getText(String value) {
	Text text= new Text();
	text.caption=value;
	text.font=getFont(15);
		return text;
	}

	private Font getFont(int size) {
		Font font=new Font();
		
		font.style="normal";
		font.weight="normal";
		font.decoration="none";
		font.size=size;
		font.color="#000000";
		return font;
	}

	private Dimensions getParentDimensions() {
		Dimensions dimensions= new Dimensions();
		dimensions.x=4000;
		dimensions.y=2000;
		return dimensions;
	}

	private Dates getDates() {
		Dates dates=new Dates();
		dates.created="1382095536507";
		dates.modified="1382096602633";
		return dates;
	}
	
}
