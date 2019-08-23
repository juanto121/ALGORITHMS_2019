package DIV2_EDU_71;

import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int cases = scan.nextInt();
    for(int t = 0; t < cases; t++) {
      int b = scan.nextInt();
      int p = scan.nextInt();
      int f = scan.nextInt();
      int h = scan.nextInt();
      int c = scan.nextInt();

      int maxbuns = b/2;
      int sum = 0;
      int rem = 0;

      if(maxbuns > 0)
      if(h > c) {
        rem = Math.min(maxbuns, p);
        sum +=  rem * h;
      } else {
        rem = Math.min(maxbuns, f);
        sum +=  rem * c;
      }

      maxbuns -= rem;

      if(maxbuns > 0) {
        if(h > c) {
          sum += Math.min(maxbuns, f) * c;
        } else {
          sum += Math.min(maxbuns, p) * h;
        }
      }

      System.out.println(sum);
    }
  }
}
