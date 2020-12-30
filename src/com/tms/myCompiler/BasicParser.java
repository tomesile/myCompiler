package com.tms.myCompiler;
import java.util.HashSet;

import static com.tms.myCompiler.syntacticAnalysis.Parser.rule;
import com.tms.myCompiler.lexicalAnalysis.Lexer;
import com.tms.myCompiler.syntacticAnalysis.AstTree;
import com.tms.myCompiler.syntacticAnalysis.NullStmnt;
import com.tms.myCompiler.syntacticAnalysis.Parser;
import com.tms.myCompiler.syntacticAnalysis.Parser.Operators;
import com.tms.myCompiler.utils.BinaryExpr;
import com.tms.myCompiler.utils.BlockStmnt;
import com.tms.myCompiler.utils.IfStmnt;
import com.tms.myCompiler.utils.Name;
import com.tms.myCompiler.utils.NegativeExpr;
import com.tms.myCompiler.utils.NumberLiteral;
import com.tms.myCompiler.utils.ParseException;
import com.tms.myCompiler.utils.PrimaryExpr;
import com.tms.myCompiler.utils.StringLiteral;
import com.tms.myCompiler.utils.Token;
import com.tms.myCompiler.utils.WhileStmnt;
	
	public class BasicParser {
	    HashSet<String> reserved = new HashSet<String>();
	    Operators operators = new Operators();
	    Parser program;
	    public void start()
	    {
	    	Parser expr0 = rule();
		    Parser primary = rule(PrimaryExpr.class)
		        .or(rule().sep("(").ast(expr0).sep(")"),
		            rule().number(NumberLiteral.class),
		            rule().identifier(Name.class, reserved),
		            rule().string(StringLiteral.class));
		    Parser factor = rule().or(rule(NegativeExpr.class).sep("-").ast(primary),
		                              primary);                               
		    Parser expr = expr0.expression(BinaryExpr.class, factor, operators);

		    Parser statement0 = rule();
		    Parser block = rule(BlockStmnt.class)
		        .sep("{").option(statement0)
		        .repeat(rule().sep(";", Token.EOL).option(statement0))
		        .sep("}");
		    Parser simple = rule(PrimaryExpr.class).ast(expr);
		    Parser statement = statement0.or(
		            rule(IfStmnt.class).sep("if").ast(expr).ast(block)
		                               .option(rule().sep("else").ast(block)),
		            rule(WhileStmnt.class).sep("while").ast(expr).ast(block),
		            simple);

		    program = rule().or(statement, rule(NullStmnt.class))
		                           .sep(";", Token.EOL);
	    }

	    public BasicParser() {
	        reserved.add(";");
	        reserved.add("}");
	        reserved.add(Token.EOL);

	        operators.add("=", 1, Operators.RIGHT);
	        operators.add("==", 2, Operators.LEFT);
	        operators.add(">", 2, Operators.LEFT);
	        operators.add("<", 2, Operators.LEFT);
	        operators.add("+", 3, Operators.LEFT);
	        operators.add("-", 3, Operators.LEFT);
	        operators.add("*", 4, Operators.LEFT);
	        operators.add("/", 4, Operators.LEFT);
	        operators.add("%", 4, Operators.LEFT);
	    }
	    public AstTree parse(Lexer lexer) throws ParseException {
	    	start();
	        return program.parse(lexer);
	    }
	   
	}


