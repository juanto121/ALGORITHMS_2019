package DIV2_558;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int oc[] = new int[11];
        int min = (int) 10e8;
        int max = Integer.MIN_VALUE;
        int maxStreak = -1;
        for(int i = 0; i < n; i++) {
            int u = scan.nextInt();

            if(max == min + 1) {
                maxStreak = i;
            }

            if(max < oc[u]) {
                max = oc[u];
            }
            if(min > oc[u]) {
                min = oc[u];
            }

            oc[u]++;
        }
        System.out.println(maxStreak);
    }
}
