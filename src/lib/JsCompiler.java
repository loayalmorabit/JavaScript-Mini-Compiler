/* JsCompiler.java */
/* Generated By:JavaCC: Do not edit this line. JsCompiler.java */
package lib;

import nodes.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsCompiler implements JsCompilerConstants {
    private static HashMap<String, Double> variables = new HashMap<>();

    public static void main(String[] args) throws ParseException {
        System.out.println("Let's Dive In");
        JsCompiler parser = new JsCompiler(System.in);
        treeNode n = parser.start();
        System.out.println("Parsing completed, executing the tree...");
         try {
            n.execute();
        } catch (RuntimeException e) {
            System.err.println("Execution error: " + e.getMessage());
        }
    }

    public static void assignVariable(String variableName, double value) {
        variables.put(variableName, value);
    }

    public static double getVariableValue(String variableName) {
        if (variables.containsKey(variableName)) {
            return variables.get(variableName);
        } else {
            throw new RuntimeException("Variable " + variableName + " not defined.");
        }
    }

    public static void printResult(double result) {
        if (result == (int) result) {
            System.out.println((int) result);
        } else {
            System.out.println(result);
        }
    }

  static final public treeNode start() throws ParseException, ParseException {treeNode n;
    n = statements();
{if ("" != null) return n;}
    throw new Error("Missing return statement in function");
}

  static final public statementsNode statements() throws ParseException, ParseException {statementsNode s = new statementsNode();
    treeNode n;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case LET:
      case LOG:
      case IF:
      case FOR:
      case WHILE:
      case DO:
      case SWITCH:
      case BREAK:
      case IDENTIFIER:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      n = statement();
s.addChild(n);
    }
{if ("" != null) return s;}
    throw new Error("Missing return statement in function");
}

  static final public treeNode statement() throws ParseException, ParseException {treeNode n;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case LET:
    case IDENTIFIER:{
      n = assignmentStatement();
      break;
      }
    case LOG:{
      n = outputNode();
      break;
      }
    case IF:{
      n = ifStatement();
      break;
      }
    case FOR:{
      n = forNode();
      break;
      }
    case WHILE:{
      n = whileStatement();
      break;
      }
    case DO:{
      n = doWhileStatement();
      break;
      }
    case SWITCH:{
      n = switchStatement();
      break;
      }
    case BREAK:{
      n = breakStatement();
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return n;}
    throw new Error("Missing return statement in function");
}

  static final public assignmentNode assignmentStatement() throws ParseException, ParseException {Token t1;
    treeNode expr;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case LET:{
      jj_consume_token(LET);
      t1 = jj_consume_token(IDENTIFIER);
      jj_consume_token(EQUAL);
      expr = expression();
      jj_consume_token(SEMICOLON);
{if ("" != null) return new assignmentNode(t1.image, expr);}
      break;
      }
    case IDENTIFIER:{
      t1 = jj_consume_token(IDENTIFIER);
      jj_consume_token(EQUAL);
      expr = expression();
      jj_consume_token(SEMICOLON);
{if ("" != null) return new assignmentNode(t1.image, expr);}
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  static final public outputNode outputNode() throws ParseException, ParseException {treeNode expr;
    jj_consume_token(LOG);
    expr = expression();
    jj_consume_token(SEMICOLON);
{if ("" != null) return new outputNode(expr);}
    throw new Error("Missing return statement in function");
}

  static final public ifNode ifStatement() throws ParseException, ParseException {treeNode condition, thenPart, elsePart = null;
    jj_consume_token(IF);
    jj_consume_token(LPAREN);
    condition = comparison();
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACE);
    thenPart = statements();
    jj_consume_token(RBRACE);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case ELSE:{
      jj_consume_token(ELSE);
      jj_consume_token(LBRACE);
      elsePart = statements();
      jj_consume_token(RBRACE);
      break;
      }
    default:
      jj_la1[3] = jj_gen;
      ;
    }
{if ("" != null) return new ifNode(condition, thenPart, elsePart);}
    throw new Error("Missing return statement in function");
}

  static final public forNode forNode() throws ParseException, ParseException {treeNode init = null, condition = null, update = null, body = null;
    jj_consume_token(FOR);
    jj_consume_token(LPAREN);
    init = assignmentStatement();
    condition = comparison();
    jj_consume_token(SEMICOLON);
    update = assignmentStatement();
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACE);
    body = statements();
    jj_consume_token(RBRACE);
{if ("" != null) return new forNode(init, condition, update, body);}
    throw new Error("Missing return statement in function");
}

  static final public whileNode whileStatement() throws ParseException, ParseException {treeNode condition = null, body = null;
    jj_consume_token(WHILE);
    jj_consume_token(LPAREN);
    condition = comparison();
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACE);
    body = statements();
    jj_consume_token(RBRACE);
{if ("" != null) return new whileNode(condition, body);}
    throw new Error("Missing return statement in function");
}

  static final public doWhileNode doWhileStatement() throws ParseException, ParseException {treeNode body = null, condition = null;
    jj_consume_token(DO);
    jj_consume_token(LBRACE);
    body = statements();
    jj_consume_token(RBRACE);
    jj_consume_token(WHILE);
    jj_consume_token(LPAREN);
    condition = comparison();
    jj_consume_token(RPAREN);
    jj_consume_token(SEMICOLON);
{if ("" != null) return new doWhileNode(body, condition);}
    throw new Error("Missing return statement in function");
}

  static final public switchNode switchStatement() throws ParseException, ParseException {treeNode expr = null;
    switchCaseNode sc = null;
    List<switchCaseNode> scl = new ArrayList<>();
    jj_consume_token(SWITCH);
    jj_consume_token(LPAREN);
    expr = expression();
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACE);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case CASE:
      case DEF:{
        ;
        break;
        }
      default:
        jj_la1[4] = jj_gen;
        break label_2;
      }
      sc = switchCase();
scl.add(sc);
    }
    jj_consume_token(RBRACE);
{if ("" != null) return new switchNode(expr, scl);}
    throw new Error("Missing return statement in function");
}

  static final public switchCaseNode switchCase() throws ParseException, ParseException {Token t = null;
    List<treeNode> body = new ArrayList<>();
    boolean isDefault = false;
    treeNode n;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case CASE:{
      jj_consume_token(CASE);
      t = jj_consume_token(NUMBER);
      jj_consume_token(COLON);
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case LET:
        case LOG:
        case IF:
        case FOR:
        case WHILE:
        case DO:
        case SWITCH:
        case BREAK:
        case IDENTIFIER:{
          ;
          break;
          }
        default:
          jj_la1[5] = jj_gen;
          break label_3;
        }
        n = statement();
body.add(n);
      }
      break;
      }
    case DEF:{
      jj_consume_token(DEF);
      jj_consume_token(COLON);
isDefault = true;
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case LET:
        case LOG:
        case IF:
        case FOR:
        case WHILE:
        case DO:
        case SWITCH:
        case BREAK:
        case IDENTIFIER:{
          ;
          break;
          }
        default:
          jj_la1[6] = jj_gen;
          break label_4;
        }
        n = statement();
body.add(n);
      }
      break;
      }
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return new switchCaseNode(t != null ? t.image : null, isDefault, body);}
    throw new Error("Missing return statement in function");
}

  static final public breakNode breakStatement() throws ParseException, ParseException {
    jj_consume_token(BREAK);
    jj_consume_token(SEMICOLON);
{if ("" != null) return new breakNode();}
    throw new Error("Missing return statement in function");
}

  static final public expressionNode expression() throws ParseException, ParseException {expressionNode e = new expressionNode();
    treeNode left, right;
    stringNode op;
    Token t;
    left = term();
e.addChild(left);
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PLUS:
      case MINUS:{
        ;
        break;
        }
      default:
        jj_la1[8] = jj_gen;
        break label_5;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PLUS:{
        t = jj_consume_token(PLUS);
        break;
        }
      case MINUS:{
        t = jj_consume_token(MINUS);
        break;
        }
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
op = new stringNode(t.image);
      right = term();
e.addChild(op); e.addChild(right);
    }
{if ("" != null) return e;}
    throw new Error("Missing return statement in function");
}

  static final public comparisonNode comparison() throws ParseException, ParseException {comparisonNode c = new comparisonNode();
    treeNode left, right;
    stringNode op;
    Token t;
    left = term();
c.addChild(left);
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case GT:
      case LT:
      case GE:
      case LE:
      case EQ:
      case NE:{
        ;
        break;
        }
      default:
        jj_la1[10] = jj_gen;
        break label_6;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case GT:{
        t = jj_consume_token(GT);
        break;
        }
      case LT:{
        t = jj_consume_token(LT);
        break;
        }
      case GE:{
        t = jj_consume_token(GE);
        break;
        }
      case LE:{
        t = jj_consume_token(LE);
        break;
        }
      case EQ:{
        t = jj_consume_token(EQ);
        break;
        }
      case NE:{
        t = jj_consume_token(NE);
        break;
        }
      default:
        jj_la1[11] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
op = new stringNode(t.image);
      right = term();
c.addChild(op); c.addChild(right);
    }
{if ("" != null) return c;}
    throw new Error("Missing return statement in function");
}

  static final public termNode term() throws ParseException, ParseException {termNode t = new termNode();
    treeNode left, right;
    stringNode op;
    Token tok;
    left = factor();
t.addChild(left);
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case MULTIPLY:
      case DIVIDE:{
        ;
        break;
        }
      default:
        jj_la1[12] = jj_gen;
        break label_7;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case MULTIPLY:{
        tok = jj_consume_token(MULTIPLY);
        break;
        }
      case DIVIDE:{
        tok = jj_consume_token(DIVIDE);
        break;
        }
      default:
        jj_la1[13] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
op = new stringNode(tok.image);
      right = factor();
t.addChild(op); t.addChild(right);
    }
{if ("" != null) return t;}
    throw new Error("Missing return statement in function");
}

  static final public factorNode factor() throws ParseException, ParseException {factorNode f = null;
    Token tok;
    treeNode expr;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case NUMBER:{
      tok = jj_consume_token(NUMBER);
f = new constNode(tok.image);
      break;
      }
    case LPAREN:{
      jj_consume_token(LPAREN);
      expr = expression();
      jj_consume_token(RPAREN);
f = new factorNode(expr);
      break;
      }
    case IDENTIFIER:{
      tok = jj_consume_token(IDENTIFIER);
f = new variableNode(tok.image);
      break;
      }
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return f;}
    throw new Error("Missing return statement in function");
}

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public JsCompilerTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[15];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
	   jj_la1_init_0();
	   jj_la1_init_1();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x33da,0x33da,0x2002,0x20,0xc00,0x33da,0x33da,0xc00,0x18000,0x18000,0xf8000000,0xf8000000,0x60000,0x60000,0x106000,};
	}
	private static void jj_la1_init_1() {
	   jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x1,0x1,0x0,0x0,0x0,};
	}

  /** Constructor with InputStream. */
  public JsCompiler(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public JsCompiler(java.io.InputStream stream, String encoding) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser.  ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new JsCompilerTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public JsCompiler(java.io.Reader stream) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser. ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new JsCompilerTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new JsCompilerTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public JsCompiler(JsCompilerTokenManager tm) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser. ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(JsCompilerTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  static private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[37];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 15; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		   if ((jj_la1_1[i] & (1<<j)) != 0) {
			 la1tokens[32+j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 37; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  static private boolean trace_enabled;

/** Trace enabled. */
  static final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
