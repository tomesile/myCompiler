package com.tms.myCompiler.utils;

import java.util.List;

import com.tms.myCompiler.Environment;
import com.tms.myCompiler.syntacticAnalysis.AstBranch;
import com.tms.myCompiler.syntacticAnalysis.AstTree;
import com.tms.myCompiler.syntacticAnalysis.AstLeaf;
public class BinaryExpr extends AstBranch{
	public BinaryExpr(){}
	public BinaryExpr(List<AstTree> ls){super(ls);}
	private int TRUE=1;
	private int FALSE=0;
	
	public AstTree left() { return child(0); }
    public String operator() {
        return ((AstLeaf)child(1)).token().getText();
    }
    public AstTree right() { return child(2); }
	public Object eval(Environment env) throws Exception {
        String op = operator();
        if ("=".equals(op)) {
            Object right = ((AstTree)right()).eval(env);
            return computeAssign(env, right);
        }
        else {
            Object left = ((AstTree)left()).eval(env);
            Object right = ((AstTree)right()).eval(env);
            return computeOp(left, op, right);
        }
    }
    protected Object computeAssign(Environment env, Object rvalue) throws Exception {
        AstTree l = left();
        if (l instanceof Name) {
            env.put(((Name)l).name(), rvalue);
            return rvalue;
        }
        else
            throw new Exception("bad assignment");
    }
    protected Object computeOp(Object left, String op, Object right) throws Exception {
        if (left instanceof Integer && right instanceof Integer) {
            return computeNumber((Integer)left, op, (Integer)right);
        }
        else
            if (op.equals("+"))
                return String.valueOf(left) + String.valueOf(right);
            else if (op.equals("==")) {
                if (left == null)
                    return right == null ? TRUE : FALSE;
                else
                    return left.equals(right) ? TRUE : FALSE;
            }
            else
                throw new Exception("bad type");
    }
    protected Object computeNumber(Integer left, String op, Integer right) throws Exception {
        int a = left.intValue(); 
        int b = right.intValue();
        if (op.equals("+"))
            return a + b;
        else if (op.equals("-"))
            return a - b;
        else if (op.equals("*"))
            return a * b;
        else if (op.equals("/"))
            return a / b;
        else if (op.equals("%"))
            return a % b;
        else if (op.equals("=="))
            return a == b ? TRUE : FALSE;
        else if (op.equals(">"))
            return a > b ? TRUE : FALSE;
        else if (op.equals("<"))
            return a < b ? TRUE : FALSE;
        else
            throw new Exception("bad operator");
    }
}
