package DIV2_551;

import java.util.Scanner;

public class C {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int slen = Integer.parseInt(scan.nextLine());
    String s = scan.nextLine();
    StringBuilder stb = new StringBuilder();
    String res[] = new String[slen];

    try {
      makeValid(s, 0, slen - 1, res, 1);
    } catch(IllegalStateException e){
      System.out.println(":(");
      return;
    }

    for(String rs: res){
      stb.append(rs);
    }
    System.out.println(stb.toString());
  }

  private static void makeValid(String s, int firsti, int lasti, String[] res, int index) {
    if(firsti > lasti) return;
    if(firsti == lasti) throw new IllegalStateException("");

    char first = s.charAt(firsti);
    char last = s.charAt(lasti);

    if(first == '(' || first == '?') {
      res[firsti] = "(";
      if(last == '?'){
        res[lasti] = ")";
      }else{
        if(last != ')'){
          throw new IllegalStateException();
        }
      }
    }else{
      throw new IllegalStateException("");
    }

    makeValid(s, firsti+1, lasti-1, res, index+1);

  }
}
