package DIV3_550;

import java.util.Arrays;
import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = Integer.parseInt(scan.nextLine());
    for(int i = 0 ; i < n; i++){
      String s = scan.nextLine();

      boolean div = true;
      char []sc = s.toCharArray();
      Arrays.sort(sc);
      int count[] = new int[30];
      int first = sc[0];
      for(char c: sc){
        if(c-first != 0) div = false;
        first++;
        count[c-'a']++;
      }

      for(int f: count){
        if(f!=1 && f != 0) div = false;
      }

      System.out.println(div ? "yes":"no");
    }
  }
}
