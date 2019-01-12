package DIV2_EDU_57;

import java.util.Scanner;

public class B {
    public static int MOD = 998244353;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String s = scan.nextLine();
        long leftonly = 1;
        boolean allEq = true;
        char firstL = s.charAt(0);
        for(int i = 1; i <n; i++){
            allEq = firstL == s.charAt(i);
            if(!allEq)break;
            leftonly += 1;
        }
        allEq = true;
        char firstR = s.charAt(n-1);
        long rightOnly = 1;
        for(int i = n-2; i >= 0; i--){
            allEq = firstR == s.charAt(i);
            if(!allEq)break;
            rightOnly += 1;
        }
        long t = leftonly + rightOnly + (firstL == firstR ? leftonly*rightOnly: 0)%MOD + 1;
        System.out.println(t%MOD);
    }
}
