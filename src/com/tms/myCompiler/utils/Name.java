package com.tms.myCompiler.utils;

import com.tms.myCompiler.Environment;
import com.tms.myCompiler.syntacticAnalysis.AstLeaf;

public class Name extends AstLeaf{
	public Name(Token t) { super(t); }
	public Object eval(Environment env) throws Exception {
        Object value = env.get(name());
        if (value == null)
            throw new Exception("undefined name: " + name());
        else
            return value;
    }
	public String name() {return token().getText();}

}
