package com.automindmap.repositories;

import com.automindmap.irepositories.*;



public class UnitOfWork {

public IInputRepository input= new InputRepository();
public IMindMapRepository mindMap =new MindMapRepository();
public INodeRepository node= new NodeRepository();
public ISentenceRepository sentecs =new SentenceRepository();
public IUserRepository user= new UserRepository();
public INLPRepository nlp=new OpenNLPRepository();
	
}
