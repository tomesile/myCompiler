package com.tms.myCompiler.syntacticAnalysis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.tms.myCompiler.Environment;

public abstract class AstTree implements Iterable<AstTree>{
	
	AstTree parent=null;
	List<AstLeaf> leafList=null;
	List<AstBranch> branchList=null;
	
	
	int leafCount=0;
	int branchCount=0;
	
	public abstract Iterator<AstTree> children();
	public abstract AstTree child(int i);
	public abstract String location();
	public abstract int numOfChildren();
	public abstract Object eval(Environment env) throws Exception;
	
	public AstTree() {
		System.out.print("I am a Ast !\n");
		leafList=new ArrayList<AstLeaf>();
		branchList=new ArrayList<AstBranch>();
	};
	public AstTree(AstTree tree)
	{
		this.parent=tree;
	}
	public int numChildren()
	{
		return branchCount;
		
	}
	public Boolean traversalLeafList() throws Exception
	{
		
		if (leafList.isEmpty()) return false;
		for(AstLeaf item:leafList)
		{
			
			System.out.print(" "+item.toStrings()+" ");
		}
		return true;

	}
	protected Boolean traversalBranchList()
	{
		if(branchList.isEmpty()) return false;
		for(AstBranch item:branchList)
		{
			
			System.out.print(item.toString());
		}
		return true;
		
	}
	
	public Boolean AddToLeafList(AstLeaf leaf)
	{
		leafCount=0;
		if(leaf instanceof AstLeaf)
		{
			leafList.add(leaf);
			leafCount++;
			return true;
		}
		return false;
			
	}
	
	public Boolean AddToBranchList(AstBranch branch)
	{
		branchCount=0;
		if(branch instanceof AstBranch)
		{
			branchList.add(branch);
			branchCount++;
			return true;
		}
		return false;
	}
	
	//properties
	public int getLeafCount()
	{
		return leafCount;
	}
	public int getBranchCount()
	{
		return branchCount;
	}
	public void setParent(AstTree tree)
	{
		this.parent=tree;
	}
	public AstTree getParent()
	{
		return this.parent;
	}
	@Override
	public Iterator<AstTree> iterator() {
		// TODO Auto-generated method stub
		return children();
	}
}
