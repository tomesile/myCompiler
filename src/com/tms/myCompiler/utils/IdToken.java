package com.tms.myCompiler.utils;

public class IdToken extends Token{

	protected IdToken(int line) {
		super(line);
		// TODO Auto-generated constructor stub
	}
	public boolean isIdentifier() { return true; }

}
