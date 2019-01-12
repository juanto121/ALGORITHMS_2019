package DIV2_530;

import java.util.Scanner;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringTokenizer str = new StringTokenizer(scan.nextLine());
        int w = Integer.parseInt(str.nextToken());
        int h = Integer.parseInt(str.nextToken());
        str = new StringTokenizer(scan.nextLine());
        int u1 = Integer.parseInt(str.nextToken());
        int d1 = Integer.parseInt(str.nextToken());
        str = new StringTokenizer(scan.nextLine());
        int u2 = Integer.parseInt(str.nextToken());
        int d2 = Integer.parseInt(str.nextToken());
        int wt = w;
        for(int i = h; i >= 0; i--) {
            wt += i;
            if(i == d1){
                wt = Math.max(0, wt - u1);
            }
            if(i == d2){
                wt = Math.max(0, wt - u2);
            }
        }
        System.out.println(wt);
    }
}
