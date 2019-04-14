package DIV2_551;

import java.util.Arrays;
import java.util.Scanner;

public class B {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String nmh[] = scan.nextLine().split(" ");
    int n = Integer.parseInt(nmh[0]);
    int m = Integer.parseInt(nmh[1]);
    int h = Integer.parseInt(nmh[2]);
    int front[] = Arrays.stream(scan.nextLine().split(" ")).mapToInt(it -> Integer.parseInt(it)).toArray();
    int left[] = Arrays.stream(scan.nextLine().split(" ")).mapToInt(it -> Integer.parseInt(it)).toArray();
    int height[][] = new int[n][m];
    int hm[][] = new int[n][m];

    for(int i = 0; i < n; i++){
      height[i] = Arrays.stream(scan.nextLine().split(" ")).mapToInt(it -> Integer.parseInt(it)).toArray();
    }

    for(int i = 0; i < m; i++){
      for(int j = n-1; j >= 0; j--){
        if(height[j][i]!=0){
          hm[j][i] = front[i];
        }
      }
    }

    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        if(height[i][j]!=0){
          hm[i][j] = Math.min(hm[i][j], left[i]);
        }
      }
    }

    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        if(j == 0) System.out.print(hm[i][j]);
        else System.out.print(" "+hm[i][j]);
      }
      System.out.println("");
    }
  }
}
