package com.tms.myCompiler.utils;

import java.util.List;

import com.tms.myCompiler.Environment;
import com.tms.myCompiler.syntacticAnalysis.AstBranch;
import com.tms.myCompiler.syntacticAnalysis.AstTree;
public class NegativeExpr extends AstBranch{
	public NegativeExpr() {}
	public NegativeExpr(List<AstTree> ls){super(ls);}
	public Object eval(Environment env) throws Exception {
        Object v = ((AstTree)operand()).eval(env);
        if (v instanceof Integer)
            return new Integer(-((Integer)v).intValue());
        else
            throw new Exception("bad type for -");
    }
	 public AstTree operand() { return child(0); }
	    public String toString() {
	        return "-" + operand();
	    }

}
