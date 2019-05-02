package DIV2_EDU_64;

import java.util.Arrays;
import java.util.Scanner;

public class C {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    long z = scan.nextLong();
    long nums[] = new long[n];
    for(int k = 0; k < n; k++) nums[k] = scan.nextInt();
    int first = 0;
    int second = n/2;
    boolean paired[] = new boolean[n];
    int count = 0;
    Arrays.sort(nums);
    for(int i = first; i < n && first < n && !paired[first]; i++) {
      while(first >= second){
        second++;
      }

      for(int j = second; j < n && second < n && !paired[second]; j++) {
        if(nums[second] - nums[first] >= z){
          count++;
          paired[first] = true; paired[second] = true;
          first++;second++;
          break;
        } else {
          second++;
        }
      }

      while(first < n && paired[first]) {
        first++;
      }

    }

    System.out.println(count);

  }
}
