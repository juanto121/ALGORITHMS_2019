package DIV2_554;

import java.util.Scanner;

public class CSol {

  public static int gcd(int a, int b) {
    if(b == 0) return a;
    return gcd(b,a%b);
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt();
    int b = scan.nextInt();

    int min = Math.min(a,b);
    int max = Math.max(a,b);

    if(gcd(a,b) == min) {
      System.out.println(0);
      return;
    }

    int diff = Math.max(b,a) - Math.min(a,b);
    int multiple = diff;
    int i = 2;
    while(multiple < Math.min(a,b)) {
      multiple = diff * i;
      i++;
    }

    while(multiple > min && (multiple + diff)%multiple == 0) {
      int factor = (multiple + diff)/multiple;
      int tempmult = multiple / factor;
      if(tempmult < min) break;
      else multiple = tempmult;
    }

    int k = multiple - min;
    System.out.println(k);
  }
}