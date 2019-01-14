package DIV3_531;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        long res = (n*(n+1))/2;
        System.out.println(res%2);
    }
}
