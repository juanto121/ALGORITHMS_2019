package DIV2_530;

import java.util.Scanner;

public class B {

    public static int MX = 31630;
    public static int msq[] = new int[2*MX];

    public static void main(String[] args) {
        int index = 0;
        int i = 1; int j = 1;
        while(index < msq.length){
            msq[index] = i * j;
            if(i == j) i++;
            else j++;
            index++;
        }
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        System.out.println(solve(n));
    }

    private static int solve(int n) {
        if(n < 4) return n+1;
        for(int i = 0; i < 2*MX; i++){
         if(n <= msq[i]){
             return i + 2;
         }
        }
        return 0;
    }

}
