package DIV2_GOODBYE_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bfr.readLine());
        long x = 0;
        long y = 0;
        for(int i = 0; i < 2*n; i++){
            String comp[] = bfr.readLine().split(" ");
            x += Integer.parseInt(comp[0]);
            y += Integer.parseInt(comp[1]);
        }
        System.out.println(x/n + " " + y/n);
    }
}
