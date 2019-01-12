package DIV3_529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bfr.readLine());
        StringTokenizer str = new StringTokenizer(bfr.readLine());
        Integer[] items = new Integer[n];
        for(int i = 0; i < n; i++){
            items[i] = Integer.parseInt(str.nextToken());
        }
        Arrays.sort(items);
        int stability = Math.min(items[n-1]-items[1], items[n-2]-items[0]);
        System.out.println(stability);

    }
}
