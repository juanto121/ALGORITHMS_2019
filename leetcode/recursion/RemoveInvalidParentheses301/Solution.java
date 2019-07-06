package RemoveInvalidParentheses301;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

  public Boolean checkValidSolution(String s) {
    String valid = removeInvalidParenthesesString(s);
    GenerateAllValidSolutions solutions = new GenerateAllValidSolutions();
    solutions.removeAllInvalidParentheses(s);
    return solutions.allValid.contains(valid);
  }

  public String removeInvalidParenthesesString(String s) {
    List<Expression> original = buildOriginal(s);
    Stack<Expression> stack = new Stack<>();
    int len = s.length();

    for(int i = 0; i < len; i++) {
      Expression c = original.get(i);
      if(c.val.equals("(")) {
        stack.push(c);
      } else if( c.val.equals(")")) {
        List<Expression> expression = new ArrayList<>();
        expression.add(c);
        boolean validExpression = false;
        while(!stack.isEmpty()) {
          if(stack.peek().val.equals("(")) {
            expression.add(0, stack.pop());
            validExpression = true;
            break;
          } else {
            expression.add(0,stack.pop());
          }
        }
        if(validExpression) {
          stack.add(new Expression(expression));
        }else{
          for(Expression e: expression){
            stack.add(e);
          }
        }
      } else {
        stack.push(c);
      }
    }

    List<Expression> finalExpression = new ArrayList<>();
    while (!stack.isEmpty()){
      Expression e = stack.pop();
      if(!e.simple) {
        finalExpression.add(0, e);
      }
    }

    Expression resulting = new Expression(finalExpression);

    return resulting.val;
  }

  private List<Expression> buildOriginal(String s) {
    List<Expression> original = new ArrayList<>();
    for(char c: s.toCharArray()) {
      original.add(new Expression(String.valueOf(c), true));
    }
    return original;
  }

  @Test
  public void test() {
    Assert.assertEquals(true, checkValidSolution("((a))"));
    Assert.assertEquals(true, checkValidSolution(""));
  }

  @Test
  public void testInvalid() {
    Assert.assertEquals(true, checkValidSolution("(((()())"));
  }

  @Test
  public void testInvalid2() {
    Assert.assertEquals(true, checkValidSolution("(((("));
  }

  @Test
  public void testInvalid3() {
    Assert.assertEquals(true, checkValidSolution("()())()"));
  }

  @Test
  public void testInvalid4() {
    Assert.assertEquals(true, checkValidSolution("((()("));
  }

  @Test
  public void testInvalid6() {
    Assert.assertEquals(true, checkValidSolution(")("));
  }


  @Test
  public void testInvalid7() {
    Assert.assertEquals(true, checkValidSolution(")("));
  }


  @Test
  public void testInvalid8() {
    Assert.assertEquals(true, checkValidSolution(")(()()())()(()(()(()()()()("));
    Assert.assertEquals(true, checkValidSolution(")(()()())(()(()()()()("));
    Assert.assertEquals(true, checkValidSolution(")(()()())(()(()()()()("));
    Assert.assertEquals(true, checkValidSolution(")(()()(((((()(()()()()("));
    Assert.assertEquals(true, checkValidSolution(")(()())())(()(()()()()("));
    Assert.assertEquals(true, checkValidSolution(")(()()())(()()()()("));
    Assert.assertEquals(true, checkValidSolution(")(()()())()()()("));
    Assert.assertEquals(true, checkValidSolution(")(()()())()(()((()()()("));
    Assert.assertEquals(true, checkValidSolution("(((((((("));
    Assert.assertEquals(true, checkValidSolution("(((((((()"));
    Assert.assertEquals(true, checkValidSolution("))))))))"));
    Assert.assertEquals(true, checkValidSolution("))))))))("));
  }

  @Test
  public void testInvalid9() {
    Assert.assertEquals(true, checkValidSolution(")"));
    Assert.assertEquals(true, checkValidSolution("("));
    Assert.assertEquals(true, checkValidSolution(")("));
    Assert.assertEquals(true, checkValidSolution("))(("));
    Assert.assertEquals(true, checkValidSolution("(("));
    Assert.assertEquals(true, checkValidSolution("))"));
  }

}

class Expression {
  public String val;
  public boolean simple;
  public Expression(String v, boolean s) {
    val = v;
    simple = s;
  }

  @Override
  public String toString() {
    return val;
  }

  public Expression(List<Expression> e) {
    StringBuilder v = new StringBuilder();
    for(Expression ex: e) {
      v.append(ex.val);
    }
    this.val = v.toString();
    this.simple = false;
  }


}
