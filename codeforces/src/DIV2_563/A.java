package DIV2_563;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Integer[] a = new Integer[2*n];
        boolean allEq = true;
        a[0] = scan.nextInt();
        long tick = System.currentTimeMillis();
        for(int i = 1; i < 2*n; i++) {
            a[i] = scan.nextInt();
            if(!a[i].equals(a[i-1])) allEq = false;
        }

        if(allEq){
            System.out.println(-1);
        }else {
            Arrays.sort(a);
            StringBuilder stb = new StringBuilder();
            for(int i = 2*n-1; i>=0; i--) {
                stb.append(a[i]+" ");
            }
            System.out.println(stb);
        }
        long tock = System.currentTimeMillis();
        System.out.println(tock-tick);
    }
}
