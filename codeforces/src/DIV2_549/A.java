package DIV2_549;

import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = Integer.parseInt(scan.nextLine());
    String _doors[] = scan.nextLine().split(" ");
    int lastLeft = 0;
    int lastRight = 0;
    for(int i = 0; i < n; i++) {
      int door = Integer.parseInt(_doors[i]);
      if(door == 0) lastLeft = i;
      else lastRight = i;
    }
    System.out.println( (lastLeft < lastRight ? lastLeft: lastRight) + 1);
  }
}
