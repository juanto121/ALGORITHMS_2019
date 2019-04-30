package DIV2_556;

import java.util.Scanner;

public class B {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = Integer.parseInt(scan.nextLine());
    char grid[][] = new char[n+2][n+2];
    for(int i = 0; i < n; i++) {
      String line = scan.nextLine();
      for(int j = 0; j < n; j++) {
        grid[i+1][j+1] = line.charAt(j);
      }
    }

    for(int i = 0; i < n+2; i++){
      grid[0][i] = '#'; grid[n+1][i] = '#'; grid[i][0] = '#'; grid[i][n+1] = '#';
    }

    char mask[][] = {{'#','.','#'},
                     {'.','.','.'},
                     {'*','.','*'}};


    for(int i = 1; i < n; i++) {
      for(int j = 1; j < n; j++) {

        boolean allMatch = true;

        maskMatching: for(int mi = 0; mi < mask.length; mi++){
          for(int mj = 0; mj < mask[0].length; mj++) {
            if(mask[mi][mj] != grid[i+mi][j+mj] && mask[mi][mj] != '*'){
              allMatch = false;
              break maskMatching;
            }
          }
        }

        if(allMatch) {
          for(int mi = 0; mi < mask.length; mi++)
            for(int mj = 0; mj < mask[0].length; mj++)
              if(mask[mi][mj] == '.')
                grid[i+mi][j+mj] = '#';
        }

      }
    }

    boolean complete = true;

    gridIter: for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[0].length; j++) {
        if(grid[i][j] != '#') {
          complete = false;
          break gridIter;
        }
      }
    }

    System.out.println(complete?"YES":"NO");

  }
}
