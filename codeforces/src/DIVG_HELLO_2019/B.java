package DIVG_HELLO_2019;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int moves[] = new int[n];
        for(int t = 0; t < n; t++){
            moves[t] = Integer.parseInt(scan.nextLine());
        }
        boolean possible = sum(moves, 0, 0);
        System.out.println(possible?"YES":"NO");
    }

    public static boolean sum(int moves[], int pos, int acm){
        if(pos == moves.length){
            return acm%360 == 0;
        }else{
            return sum(moves, pos+1, acm+moves[pos]) | sum(moves, pos+1, acm-moves[pos]);
        }
    }
}
