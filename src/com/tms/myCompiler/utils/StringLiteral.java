package com.tms.myCompiler.utils;

import com.tms.myCompiler.Environment;
import com.tms.myCompiler.syntacticAnalysis.AstLeaf;

public class StringLiteral extends AstLeaf{
	public StringLiteral(){}
	public StringLiteral(Token t){super(t);}
	public Object eval(Environment e) { return value(); }
	public String value() {return token().getText();}

}
