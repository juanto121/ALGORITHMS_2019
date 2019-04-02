package DIV2_549;

import java.util.Scanner;

public class B {
  public static void main(String[] args) {
    /*
    Approach: iterate through the digits 1..n and try to put a 9 if the resulting number is greater than the original,
    subtract one from the digit at the prev position.
    eg.
    10 -> 19 > 10 so subtract 1 from prev pos -> 09 < 10
    100 -> 190 > 100 subtract 1 from prev pos -> 090 < 100 -> 99 < 100: DONE
    138 -> 198 > 138 subtract 1 from prev -> 098 < 138 -> 99 : DONE
    390 -> 39_ -> 399 > 390 so subtract 1 from prev -> 389 < 390 : DONE
     */
    Scanner scan = new Scanner(System.in);
    String original = scan.nextLine();
    long originalNum = Long.parseLong(original);
    int len = original.length();
    int prev = original.charAt(0)-'0';
    StringBuilder generated = new StringBuilder(original);

    for(int i = 1; i < len; i++){
      generated.setCharAt(i, '9');
      while(Long.parseLong(generated.toString()) > originalNum){
        generated.setCharAt(i-1, (char)((prev-1)+'0'));
      }
      prev = 9;
    }

    long generatedNum = Long.parseLong(generated.toString());
    long res = 1;

    while(generatedNum > 0){
      res *= generatedNum % 10;
      generatedNum /= 10;
    }

    System.out.println(res);
  }
}
