package com.tms.myCompiler.utils;

public class StrToken extends Token{

	private String tokenName;
	protected StrToken(int line,String str) {
		super(line);
		tokenName=str;
		// TODO Auto-generated constructor stub
	}
	public boolean isString() { return true; }
	public String getText() { return tokenName; }

}
