package DIV3_570;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {
  public static void main(String[] args) throws IOException {
    BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    int q = Integer.parseInt(bfr.readLine());
    for(int cases = 0; cases < q; cases++) {
      String nk[] = bfr.readLine().split(" ");

      long k = Long.parseLong(nk[1]);

      int arr[] = Arrays.stream(bfr.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      long min = Integer.MAX_VALUE;
      long max = Integer.MIN_VALUE;
      for (int ai : arr) {
        if (ai < min) min = ai;
        if (ai > max) max = ai;
      }

      if (max - (min + k) > k) System.out.println(-1);
      else {
        System.out.println(min + k);
      }
    }
  }
}
