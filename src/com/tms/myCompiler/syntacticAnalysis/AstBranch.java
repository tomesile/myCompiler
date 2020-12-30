package com.tms.myCompiler.syntacticAnalysis;

import java.util.Iterator;
import java.util.List;

import com.tms.myCompiler.Environment;

public class  AstBranch extends AstTree{
	 
	public  AstBranch() {
		branchCount=1;
		leafCount=1;
		System.out.print("I am a AstBranch too!\n");
	}
	public Object eval(Environment env) throws Exception {
        throw new Exception("cannot eval: " + toString());
    }
	public AstBranch(List<AstTree> list)
	{
		children=list;
	}
	
	public void AddBranchToParent( AstBranch branch)
	{
		super.AddToBranchList(branch);
	}
	public Boolean amIaBranch()
	{
		
		return leafCount>1?true:false;
	}
	//properties
	private List<AstTree> children;
	
	public List<AstTree> getChirlden()
	{
		return this.children;
	}
	public void setBranchCount(int count)
	{
		branchCount=count;
	}
	public int getBranchCount()
	{
		return branchCount;
	}
	public void setLeafCount(int count)
	{
		leafCount=count;
	}
	public int getLeafCount()
	{
		return leafCount;
	}
	public String toString()
	{
		StringBuilder builder=new StringBuilder();
		builder.append("[");
		String sep="";
		for(AstTree t:children)
		{
			builder.append(sep);
			sep=" ";
			builder.append(t.toString());
		}
		return builder.append("]").toString();
		
	}
	@Override
	public Iterator<AstTree> children() {
		// TODO Auto-generated method stub
		return children.iterator();
	}
	@Override
	public AstTree child(int i) {
		// TODO Auto-generated method stub
		return children.get(i);
	}
	@Override
	public String location() {
		// TODO Auto-generated method stub
		for(AstTree e:children)
		{
			String s=e.location();
			if(s!=null) return s;
		}
		return null;
	}
	@Override
	public int numOfChildren() {
		// TODO Auto-generated method stub
		return children.size();
	}


}
