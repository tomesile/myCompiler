package com.tms.myCompiler;

import com.tms.myCompiler.lexicalAnalysis.Lexer;
import com.tms.myCompiler.syntacticAnalysis.AstTree;
import com.tms.myCompiler.syntacticAnalysis.NullStmnt;
import com.tms.myCompiler.utils.CodeDialog;

import com.tms.myCompiler.utils.Token;


public class BasicInterpreter {
    public static void main(String[] args) throws Exception {
       run(new BasicParser(), new BasicEnv());
    }
    public static void run(BasicParser bp, Environment env)
        throws Exception
    {
        Lexer lexer = new Lexer(new CodeDialog());
        while (lexer.peek(0) != Token.EOF) {
            AstTree t = bp.parse(lexer);
            if (!(t instanceof NullStmnt)) {
                Object r = t.eval(env);
                System.out.println("=> " + r);
            }
        }
    }
}
