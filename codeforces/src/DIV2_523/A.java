package DIV2_523;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String params[] = scan.nextLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int s = Integer.parseInt(params[1]);
        int numc = change(s, n);
        System.out.println(numc);
    }

    public static int change(int s, int c){
        if(s == 1){
            return 1;
        }else{
            if(s-c > 0) {
                return 1 + change(s-c, c-1);
            }else{
                return change(s, c-1);
            }
        }
    }
}
