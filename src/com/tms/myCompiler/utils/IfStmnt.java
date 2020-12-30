package com.tms.myCompiler.utils;

import java.util.List;

import com.tms.myCompiler.Environment;
import com.tms.myCompiler.syntacticAnalysis.AstBranch;
import com.tms.myCompiler.syntacticAnalysis.AstTree;

public class IfStmnt extends AstBranch{
	public IfStmnt() {}
	
	public IfStmnt(List<AstTree> ls){super(ls);}
    public AstTree condition() { return child(0); }
    public AstTree thenBlock() { return child(1); }
    public AstTree elseBlock() {
        return numChildren() > 2 ? child(2) : null;
    }
    public String toString() {
        return "(if " + condition() + " " + thenBlock()
                 + " else " + elseBlock() + ")";
    }
  
    	 public Object eval(Environment env) throws Exception {
             Object c = ((AstTree)condition()).eval(env);
             if (c instanceof Integer && ((Integer)c).intValue() != 0)
                 return ((AstTree)thenBlock()).eval(env);
             else {
                 AstTree b = elseBlock();
                 if (b == null)
                     return 0;
                 else
                     return ((AstTree)b).eval(env);
             }
         }
}
