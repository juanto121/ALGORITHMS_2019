package DIV3_575;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class B {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    long n1 = in .nextLong();
    for (int q = 0; q < n1; q++) {
      int n = in .nextInt();
      int k = in .nextInt();
      long a[] = new long[n];
      int nOdd = 0, ii = 00;
      for (int i = 0; i < n; i++)
        if (( in .nextLong()) % 2 == 1) {
          nOdd++;
          a[ii++] = i + 1;
        }
      if (nOdd < k)
        System.out.println("NO");
      else if ((nOdd - k) % 2 == 0) {
        System.out.println("YES");
        for (int i = 0; i < k - 1; i++)
          System.out.print(a[i] + " ");
        System.out.println(n);
      } else
        System.out.println("NO");

    }
  }
}