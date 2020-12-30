package com.tms.myCompiler.utils;

import com.tms.myCompiler.Environment;
import com.tms.myCompiler.syntacticAnalysis.AstLeaf;

public class NumberLiteral extends AstLeaf{
	public NumberLiteral(){}
	public NumberLiteral(Token t){super(t);}
	public Object eval(Environment e) throws Exception { return value(); }
	public int value() throws Exception {return token().getNumber();}
}
