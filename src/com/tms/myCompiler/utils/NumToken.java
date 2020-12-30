package com.tms.myCompiler.utils;

public class NumToken extends Token{

	private int value;
	protected NumToken(int line,int v) {
		super(line);
		// TODO Auto-generated constructor stub
		value=v;
	}
	public boolean isNumber() {return true;}
	public String getText() {return Integer.toString(value);}
	public int getNumber() {return value;}

}
