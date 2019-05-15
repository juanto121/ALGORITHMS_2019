package DIV3_560;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int tc = 0; tc < t; tc++) {
            int dvs = scan.nextInt();
            int divs[] = new int[dvs];
            for(int i = 0; i < dvs; i++) {
                divs[i] = scan.nextInt();
            }

            Arrays.sort(divs);

            BigInteger x = new BigInteger("-1");
            boolean possible = true;
            int left = 0;
            int right = dvs-1;
            while(left < right) {
                BigInteger a = new BigInteger(""+divs[left++]);
                BigInteger b = new BigInteger(""+divs[right--]);
                if(x.equals(BigInteger.valueOf(-1))) x = a.multiply(b);
                else {
                    if(!a.multiply(b).equals(x)){
                        possible = false;
                    }
                }
            }

            int sq = 0;

            if(left == right) {
                BigInteger num = new BigInteger(String.valueOf(divs[left]));
                BigInteger squared = num.multiply(num);
                if(dvs == 1) {
                    possible = true;
                }else if(!squared.equals(x)){
                    possible = false;
                }
                x = squared;
                sq = num.intValue();
            }

            possible = possible && dvs == countDivs(x, sq);

            if(possible) {
                System.out.println(x);
            }else{
                System.out.println(-1);
            }
        }
    }

    private static int countDivs(BigInteger x, int sqr) {
        int divCount = 0;
        BigInteger sqrX = sqr != -1 ? BigInteger.valueOf(sqr) : BigInteger.valueOf(0);
        boolean xisSquared = sqrX.multiply(sqrX).equals(x);
        for(int i = 2; i <= sqr; i++) {
            if(x.divideAndRemainder(BigInteger.valueOf(i))[1].intValue() == 0) {
                divCount += 2;
                if(i == sqr  && xisSquared) divCount--;
            }
        }
        return divCount;
    }
}
