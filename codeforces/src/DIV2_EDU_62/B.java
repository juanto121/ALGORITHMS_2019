package DIV2_EDU_62;

import java.util.Scanner;

public class B {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int cases = Integer.parseInt(scan.nextLine());
    for(int t = 0; t < cases; t++) {
      int n = Integer.parseInt(scan.nextLine());
      String s = scan.nextLine();
      int d = toDelete(s);
      System.out.println(d);
    }
  }

  private static int toDelete(String s) {
    if(s.equals("<>")) return 1;
    if(s.length() == 1) return 0;
    if(s.charAt(0) == '<' && s.charAt(s.length()-1) == '>'){
      return 1 + toDelete(s.substring(1, s.length()-1));
    }
    return 0;
  }
}
