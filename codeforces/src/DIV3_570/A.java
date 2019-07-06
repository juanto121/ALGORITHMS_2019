package DIV3_570;

import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt();
    int sd = sumDigits(a);
    if(sd % 4 == 0) System.out.println(a);
    else {
      do {
        a = a + (4 - sd % 4);
        sd = sumDigits(a);
      } while (sd % 4 != 0);
      System.out.println(a);
    }
  }

  private static int sumDigits(int a) {
    int sum = 0;
    while(a != 0) {
      sum += a % 10;
      a /= 10;
    }
    return sum;
  }
}
