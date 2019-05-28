import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateAllValidSolutions {
  Set<String> allValid = new HashSet<>();
  int maxLenAfterRemoval = 0;

  public List<String> removeAllInvalidParentheses(String s) {

    allValid = new HashSet<>();
    maxLenAfterRemoval = 0;

    String original[] = new String[s.length()];

    for(int i = 0; i < s.length(); i++) original[i] = String.valueOf(s.charAt(i));

    int current = 0;
    int stack = 0;
    StringBuilder result = new StringBuilder();

    generate(original, current, stack, result);

    List<String> res = new ArrayList<>();

    for (String s1 : allValid) {
      if(s1.length() == maxLenAfterRemoval)
        res.add(s1);
    }

    return res;
  }

  private void generate(String[] original, int current, int stack, StringBuilder result) {
    if(current == original.length) {
      if(stack == 0) {
        int reslen = result.length();
        if(maxLenAfterRemoval <= reslen) maxLenAfterRemoval = reslen;
        if(reslen == maxLenAfterRemoval)
          allValid.add(result.toString());
      }
    } else {
      String toAppend = original[current];
      int stackDiff = 0;
      if(toAppend.equals("(")) stackDiff = stack >= 0 ? 1 : 0;
      if(toAppend.equals(")")) stackDiff = -1;

      stack += stackDiff;

      result.append(original[current]);
      generate(original, current + 1, stack, result);

      stack -= stackDiff;

      result.deleteCharAt(result.length()-1);
      generate(original, current + 1, stack, result);
    }
  }

  @Test
  public void testInValid() {
    System.out.println(removeAllInvalidParentheses(")("));
  }

  @Test
  public void testValid() {
    System.out.println(removeAllInvalidParentheses("()"));
  }

  @Test
  public void testValid1() {
    System.out.println(removeAllInvalidParentheses("(()())"));
  }

  @Test
  public void testValid2() {
    System.out.println(removeAllInvalidParentheses("(())"));
  }

  @Test
  public void testValid3() {
    System.out.println(removeAllInvalidParentheses("()()"));
  }

  @Test
  public void testInvalid1() {
    System.out.println(removeAllInvalidParentheses("()())()"));
  }

  @Test
  public void testInvalid2() {
    System.out.println(removeAllInvalidParentheses("(a)(b))()"));
  }
}
