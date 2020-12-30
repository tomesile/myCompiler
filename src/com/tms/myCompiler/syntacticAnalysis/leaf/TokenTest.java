package com.tms.myCompiler.syntacticAnalysis.leaf;

import com.tms.myCompiler.utils.Token;

public class TokenTest extends Token{

	public TokenTest(int line) {
		super(line);
		// TODO Auto-generated constructor stub
	}
	public String getText()
	{
		return "TokenTest";
	}
	
	public boolean isString()
	{
		if(getText()!=null)
		{
			return true;
		}
		return false;
	}
	

}
