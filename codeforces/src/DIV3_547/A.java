package DIV3_547;

import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int m = scan.nextInt();

    long p2 = 1;
    long p3 = 1;

    int s = -1;

    for(int a = 1; a <= 27; a++) {
      p2 *= a > 1 ? 2 : 1;
      p3 = 1;
      for(int b = 1; b <= 17; b++){
        p3 *= b > 1 ? 3 : 1;
        if(n*p2*p3 > m) break;
        if(n*p2*p3 == m){
          s = a + b;
          break;
        }
      }
    }

    System.out.println(s > 0 ? s-2 : s);
  }
}
