package com.automindmap.models;

import java.util.List;

import com.automindmap.models.MindMapView.MindMap;

public class Map {

	public int id;
	public String name;
	public int userId;
	public MindMap mindmap;
	public List<Node> nodes;
	public List<Input> inputs;
	public List<Sentence> sentences;
	
}
