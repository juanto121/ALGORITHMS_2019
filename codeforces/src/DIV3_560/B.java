package DIV3_560;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bfr.readLine());
        int contests[] = Arrays.stream(bfr.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        util u = countSort(contests);
        int count = 0;

        for(int i = 0; i <= u.max +1; i++) {
            while(i > count && u.sorted[i] > 0) {
                count++;
                u.sorted[i] --;
            }
        }

        System.out.println(count);
    }

    private static util countSort(int[] contests) {
        int sorted[] = new int[2*100_000+5];
        int max = 0;
        for(int i: contests) {
            sorted[i] ++;
            if(i > max) max = i;
        }

        util val = new util();
        val.sorted = sorted;
        val.max = max;
        return val;
    }


}


class util {
    int [] sorted;
    int max;
}