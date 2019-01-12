package DIV3_527;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = Integer.parseInt(scan.nextLine());
        for(int t = 0; t < cases; t++) {
            String nk[] = scan.nextLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            StringBuilder stb = new StringBuilder(n);
            for(int i = 0; i < n; i++){
                stb.append((char)(i%k+'a'));
            }
            System.out.println(stb.toString());
        }
    }
}
