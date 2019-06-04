package DIV2_562;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a = scan.nextInt();
        int x = scan.nextInt();
        int b = scan.nextInt();
        int y = scan.nextInt();
        int dan = a;
        int val = b;
        boolean meet = false;
        while(dan == val || (dan != x%n && val != y%n)) {
            if(dan == val){
                meet = true;
                break;
            }
            dan = (dan+1) % n;
            val = (val+n-1) % n;
        }
        if(meet) System.out.println("YES");
        else System.out.println("NO");
    }
}