package DIV3_531;

import java.util.Scanner;

public class D {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = Integer.parseInt(scan.nextLine());
    String s = scan.nextLine();
    int count[] = new int[3];

    for(int i = 0; i < n; i++){
      count[s.charAt(i)-'0']++;
    }

    StringBuilder stb = new StringBuilder(s);

    for(int i = 0; i < 3; i++) {
      int a = count[i];
      if(a == n/3) continue;
      for(int j = 2; j > i; j--) {
        int b = count[j];
        if(b == n/3) continue;

        if(a < b){
          for(int r = 0, index = 0; index < n && r < n/3 - a && r < Math.min(b-n/3,n/3); index++){
            if(stb.charAt(index) == (char)(j+'0')){
              stb.setCharAt(index, (char)(i+'0'));
              r++;
            }
          }
        }else{
          for(int index = n-1, r = 0; index >= 0 && r < n/3 - b && r < Math.min(a-n/3,n/3); index--){
            if(stb.charAt(index) == (char)(i+'0')) {
              stb.setCharAt(index, (char)(j+'0'));
              r++;
            }
          }
        }

      }
    }

    System.out.println(stb.toString());
  }
}
