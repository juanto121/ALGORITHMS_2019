import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BeautifulArray {
    Map<Integer, int[]> memo;

    public int[] beautifulArray(int N) {
        memo = new HashMap();
        return f(N);
    }

    public int[] f(int N) {
        if (memo.containsKey(N))
            return memo.get(N);

        int[] ans = new int[N];
        if (N == 1) {
            ans[0] = 1;
        } else {
            int t = 0;
            int odds[] = f((N+1)/2);
            int evens[] = f(N/2);
            for (int x: odds)  // odds
                ans[t++] = 2*x - 1;
            for (int x: evens)  // evens
                ans[t++] = 2*x;
        }
        memo.put(N, ans);
        return ans;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(beautifulArray(5)));
    }
}