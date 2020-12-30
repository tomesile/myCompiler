package com.tms.myCompiler.syntacticAnalysis;

import java.util.Iterator;
import java.util.List;

public class NullStmnt extends AstBranch {

	public NullStmnt() {}
	public NullStmnt(List<AstTree> ls){super(ls);}
	@Override
	public Iterator<AstTree> children() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AstTree child(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String location() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numOfChildren() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
