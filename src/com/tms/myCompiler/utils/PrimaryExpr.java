package com.tms.myCompiler.utils;

import java.util.List;

import com.tms.myCompiler.syntacticAnalysis.AstBranch;
import com.tms.myCompiler.syntacticAnalysis.AstTree;

public class PrimaryExpr extends AstBranch{
	public PrimaryExpr() {}
	  public PrimaryExpr(List<AstTree> c) { super(c); }
	    public static AstTree create(List<AstTree> c) {
	        return c.size() == 1 ? c.get(0) : new PrimaryExpr(c);
	    }
}
