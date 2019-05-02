package DIV2_554;

import java.util.Scanner;

public class C {

  public static int gcd(int a, int b) {
    if(b == 0) return a;
    return gcd(b,a%b);
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt();
    int b = scan.nextInt();
    int min = Integer.MAX_VALUE;
    for(int k = 0; k < 120; k++) {
      System.out.println((a+k)+" "+(b+k)+" "+gcd(a+k, b+k) + " "+ ((a+k)*(b+k)/gcd(a+k,b+k)));
    }
  }
}
