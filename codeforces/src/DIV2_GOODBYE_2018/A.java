package DIV2_GOODBYE_2018;

import java.util.Scanner;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        StringTokenizer str = new StringTokenizer(scan.nextLine());

        int min = 101;

        for(int i = 0 ; i < 3; i++) {
            int m = Integer.parseInt(str.nextToken()) - i;
            if(m < min){
                min = m;
            }
        }

        int sum = min + min +1 + min +2;
        System.out.println(sum);
    }
}
