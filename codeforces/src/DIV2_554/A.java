package DIV2_554;

import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int m = scan.nextInt();
    int co = 0,ce = 0,ko = 0,ke = 0;
    for(int i = 0; i < n; i++){
      if(scan.nextInt() % 2 == 0) ce++;
      else co++;
    }
    for(int i = 0; i < m; i++){
      if(scan.nextInt() % 2 == 0) ke++;
      else ko++;
    }
    System.out.println(Math.min(co,ke)+Math.min(ce,ko));
  }
}
