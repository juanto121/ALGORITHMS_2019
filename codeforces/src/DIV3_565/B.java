package DIV3_565;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cases = scan.nextInt();
        for(int t = 0; t < cases; t++) {
            int n = scan.nextInt();

            int possible = 0;
            int cnt2 = 0;
            int cnt1 = 0;
            for(int i = 0; i < n; i++) {
                long ai = scan.nextLong();
                ai = ai % 3;
                if(ai == 0) possible++;
                else if(ai == 2) cnt2++;
                else if(ai == 1) cnt1++;
            }
            int formed = Math.min(cnt1, cnt2);
            int leftOnes = cnt1-formed;
            int leftTwos = cnt2-formed;
            if(leftTwos < 0)
                leftTwos = 0;
            else
                leftTwos /= 3;

            if(leftOnes < 0) leftOnes = 0;
            else leftOnes/=3;
            System.out.println(possible+formed+leftOnes+leftTwos);
        }
    }
}
