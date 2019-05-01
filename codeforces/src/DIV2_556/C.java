package DIV2_556;

import java.util.Arrays;
import java.util.Scanner;

public class C {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = Integer.parseInt(scan.nextLine());
    int tiles[] = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int countOnes = 0;
    int countTwos = 0;

    for(int i = 0; i < n; i++) {
      if(tiles[i] == 1) countOnes++;
      else countTwos++;
    }

    StringBuilder stb = new StringBuilder();
    boolean gotThree = false;

    for(int i = 0; i < n; i++){
      if(countTwos > 0 && countOnes > 0 && !gotThree) {
        stb.append("2 1 ");
        gotThree = true;
        countTwos--;
        countOnes--;
        continue;
      }

      if(countTwos > 0) {
        stb.append("2 ");
        countTwos--;
        continue;
      }

      if(countOnes > 0) {
        stb.append("1 ");
        countOnes--;
        continue;
      }

    }

    System.out.println(stb.toString());
  }
}
