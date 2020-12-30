package com.tms.myCompiler.utils;

import java.util.List;

import com.tms.myCompiler.Environment;
import com.tms.myCompiler.syntacticAnalysis.AstBranch;
import com.tms.myCompiler.syntacticAnalysis.AstTree;
public class WhileStmnt extends AstBranch{
	public WhileStmnt() {}
	public WhileStmnt(List<AstTree> ls){super(ls);}
	 public AstTree condition() { return child(0); }
	    public AstTree body() { return child(1); }
	    public String toString() {
	        return "(while " + condition() + " " + body() + ")";
	    }
	    public Object eval(Environment env) throws Exception {
            Object result = 0;
            for (;;) {
                Object c = ((AstTree)condition()).eval(env);
                if (c instanceof Integer && ((Integer)c).intValue() == 0)
                    return result;
                else
                    result = ((AstTree)body()).eval(env);
            }
        }
}
