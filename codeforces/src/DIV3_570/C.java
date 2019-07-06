package DIV3_570;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {
  public static void main(String[] args) throws IOException {
    BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    int q = Integer.parseInt(bfr.readLine());

    for(int cases = 0; cases < q; cases++) {
      int knab[] = Arrays.stream(bfr.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int k = knab[0]; int n = knab[1]; int a = knab[2]; int b = knab[3];
      if(b * n < k) {
      	long ja = (k - n  * b + 1)  / (a - b);
        System.out.println(Math.max(ja,n));
      } else {
        System.out.println(-1);
      }
    }
  }
}
