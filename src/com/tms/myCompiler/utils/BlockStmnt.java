package com.tms.myCompiler.utils;

import java.util.List;

import com.tms.myCompiler.Environment;
import com.tms.myCompiler.syntacticAnalysis.AstBranch;
import com.tms.myCompiler.syntacticAnalysis.AstTree;
import com.tms.myCompiler.syntacticAnalysis.NullStmnt;

public class BlockStmnt extends AstBranch{
	public BlockStmnt() {}
	public BlockStmnt(List<AstTree> c) { super(c); }
	public Object eval(Environment env) throws Exception {
        Object result = 0;
        for (AstTree t: this) {
            if (!(t instanceof NullStmnt))
                result = ((AstTree)t).eval(env);
        }
        return result;
    }
}
