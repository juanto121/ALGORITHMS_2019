package DIV2_EDU_64;

import java.util.Arrays;
import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = Integer.parseInt(scan.nextLine());
    int figs[] = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    String result = "";
    int touchp = 0;

    for(int i = 0; i < n-1; i++) {
        int first = i;
        int second = i+1;
        if(figs[first]== 2 && figs[second] == 3 || figs[second] == 2 && figs[first] == 3){
          result = "Infinite";
          break;
        }

        if(figs[first] == 3 && figs[second] == 1 || figs[second] == 3 && figs[first] == 1) {
          touchp+=4;
        }

        if(figs[first] == 2 && figs[second] == 1 || figs[second] == 2 && figs[first] == 1) {
          touchp+=3;
          if(first > 0 && figs[first-1] == 3 && figs[second] == 2) touchp--;
        }
    }

    System.out.println(result.equals("")?"Finite\n"+touchp:result);
  }
}
