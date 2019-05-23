package DIV2_558;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        System.out.println(solve(n,m));
    }

    private static int solve(int n, int m) {
        if(n == 0) return 0;
        if(m <= 1) return 1;
        m-=1;
        n-=1;
        int count = 0;
        for(int i = 2; i <= n && count < m; i+=2) {
            count++;
        }
        boolean remains = count * 2 < n;
        return count + (remains ? 1 : 0) - (m-count);
    }
}
