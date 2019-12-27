package DIV3_565;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();

        for(int t = 0; t < cases; t++) {
            int moves = 0;
            long q = scan.nextLong();
            boolean impossible = false;
            while(q != 1 && !impossible) {
                if (q % 2 == 0) {
                    q /= 2;
                    //System.out.println("/2 " + q);
                } else if (q % 3 == 0) {
                    q /= 3;
                    q *= 2;
                    //System.out.println("/3 " + q);
                } else if (q % 5 == 0) {
                    q /= 5;
                    q *= 4;
                    //System.out.println("/5 " + q);
                } else {
                    impossible = true;
                    //System.out.println("Not divisible");
                }
                moves++;
            }
            if(impossible) System.out.println(-1);
            else System.out.println(moves);
        }

    }
}
