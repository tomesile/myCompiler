package com.tms.myCompiler.syntacticAnalysis;

import java.util.ArrayList;
import java.util.Iterator;

import com.tms.myCompiler.Environment;
import com.tms.myCompiler.utils.Token;

public class AstLeaf extends AstTree{

	
	public AstLeaf() {
		this.branchCount=0;
		this.leafCount=1;
		System.out.print("I am a AstLeaf too!\n");
	}
	 public Object eval(Environment env) throws Exception {
         throw new Exception("cannot eval: " + toString());
     }
	public AstLeaf(Token tokens)
	{
		token=tokens;
	}
	public Boolean amIaLeaf()
	{
		
		return this.branchCount==0?true:false;
	}
	public String toStrings() throws Exception
	{
		if(this.token().isString())
		    return this.token().getText();
		else if(this.token().isNumber())
		    return this.token().getNumber()+"";
		else
			return null;
		
	}
	public Token token()
	{
		return this.token;
	}
	//properties
	private Token token;
	private ArrayList<AstTree> children;
	private static ArrayList<AstTree> empty=new ArrayList<AstTree>();
	public Token getToken()
	{
		return this.token;
	}
	public void setToken(Token leaf)
	{
		this.token=leaf;
	}
	@Override
	public Iterator<AstTree> children() {
		
		// TODO Auto-generated method stub
		return empty.iterator();
	}
	@Override
	public AstTree child(int i) {
		// TODO Auto-generated method stub
		return children.get(i);
	}
	@Override
	public String location() {
		// TODO Auto-generated method stub
		return "line:"+token.getLineNumber();
	}
	@Override
	public int numOfChildren() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
