package DIV2_548;

import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = Integer.parseInt(scan.nextLine());
    String s = scan.nextLine();
    int sum = 0;
    for(int i = 0; i < n; i++){
      int c = s.charAt(i)-'0';
      if(c % 2 == 0){
        sum +=  (i+1);
      }
    }
    System.out.println(sum);
  }
}
