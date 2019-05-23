package DIV2_EDU_65;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = Integer.parseInt(scan.nextLine());
        for(int t = 0; t < cases; t++) {
            int n = Integer.parseInt(scan.nextLine());
            String s = scan.nextLine();
            int index = s.indexOf('8');
            //System.out.println(index);
            if(index == -1) {
                System.out.println("NO");
            } else {
                if(n - index >= 11)
                    System.out.println("YES");
                else
                    System.out.println("NO");

            }
        }
    }
}
