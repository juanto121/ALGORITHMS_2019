package DIV2_548;

import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class B {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = Integer.parseInt(scan.nextLine());
    String _a[] = scan.nextLine().split(" ");
    int a[] = new int[n];

    long minSoFar = Integer.parseInt(_a[n-1]);
    long sumSoFar = minSoFar;

    for(int i = n-2; i >= 0; i--){
      a[i] = Integer.parseInt(_a[i]);

      long possibleSum = Math.max(a[i] < minSoFar ? a[i] : minSoFar-1,0);

      sumSoFar += possibleSum;
      minSoFar = possibleSum;
    }

    System.out.println(sumSoFar);
  }
}

