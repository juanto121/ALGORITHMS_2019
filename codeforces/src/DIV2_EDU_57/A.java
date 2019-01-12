package DIV2_EDU_57;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bfr.readLine());
        for(int q = 0; q < t; q++){
            StringTokenizer str = new StringTokenizer(bfr.readLine());
            int l = Integer.parseInt(str.nextToken());
            int r = Integer.parseInt(str.nextToken());
            if(2*l <= r) System.out.println(l + " " + 2*l);
        }
    }
}
