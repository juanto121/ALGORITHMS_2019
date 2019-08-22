package DIV2_EDU_71;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {

  static int n = 0;
  static int m = 0;

  static int indx(int i, int j) {
    return i*m+j;
  }

  static void fill(int[][] arr, int ii, int jj, int fil) {
    for(int i = ii; i <= ii+1 && i < n; i++) {
      for (int j = jj; j <= jj+1 && j < m; j++) {
        arr[i][j] = fil;
      }
    }
  }

  static void printarr(int arr[][]) {
    for(int i = 0; i < n; i++) {
      System.out.println(Arrays.toString(arr[i]));
    }
  }


  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Set<Integer> untouch = new HashSet<>();
    n = scan.nextInt();
    m = scan.nextInt();
    int grid[][] = new int[n][m];

    for(int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        grid[i][j] = scan.nextInt();
        if(grid[i][j] == 0){
          untouch.add(indx(i,j));
          if(j-1 >= 0)
          untouch.add(indx(i,j-1));
          if(i-1 >= 0)
          untouch.add(indx(i-1,j));
          if(i-1 > 0 && j -1 > 0)
          untouch.add(indx(i-1,j-1));
        }
      }
    }

    int cnt = 0;
    StringBuilder moves = new StringBuilder();

    int b[][] = new int[n][m];

    for(int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if(!untouch.contains(indx(i,j)) && i + 1 < n && j + 1 < m) {
          cnt++;
          moves.append(String.format((i+1)+ " " + (j+1) +"%n"));
          fill(b, i, j, 1);
        }
      }
    }



    boolean equal = true;

    outer: for(int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if(grid[i][j] != b[i][j]){
          equal=false;
          break outer;
        }
      }
    }

    if(!equal){
      System.out.println(-1);
    }else{
      System.out.println(String.format(cnt+"%n"+moves) );
    }

  }
}
