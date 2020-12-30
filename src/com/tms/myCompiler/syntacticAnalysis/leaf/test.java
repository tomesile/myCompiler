package com.tms.myCompiler.syntacticAnalysis.leaf;

import com.tms.myCompiler.syntacticAnalysis.AstLeaf;
import com.tms.myCompiler.utils.Token;

public class test extends AstLeaf{

	public test(){};
	public test(Token token)
	{
		this.setToken(token);
		
	}
	public String toString()
	{
		return this.getToken().toString();
	}
}
