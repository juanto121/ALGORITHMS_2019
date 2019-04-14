package DIV2_551;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class A {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String desc[] = bf.readLine().split(" ");
    int n = Integer.parseInt(desc[0]);
    int t = Integer.parseInt(desc[1]);
    int min = Integer.MAX_VALUE;
    int mini = 0;
    for(int i = 0; i < n; i++){
      String _sd[] = bf.readLine().split(" ");
      int si = Integer.parseInt(_sd[0]);
      int di = Integer.parseInt(_sd[1]);
      for(int j = si; j <= t+di; j+=di) {
        if(j-t >= 0 && j-t < min){
          min = j-t;
          mini = i;
        }
      }
    }
    System.out.println(mini+1);
  }
}
