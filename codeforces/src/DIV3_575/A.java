package DIV3_575;

import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    long q = scan.nextLong();
    for(int cases = 0; cases < q; cases++) {
      long a = scan.nextLong();
      long b = scan.nextLong();
      long c = scan.nextLong();
      System.out.println( (a+b+c)/2 );
    }
  }
}
