package DIVG_HELLO_2019;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String table = scan.nextLine();
        String hand[] = scan.nextLine().split(" ");
        boolean canPlay = false;
        for(String card: hand){
            if(card.charAt(0) == table.charAt(0) || card.charAt(1) == table.charAt(1)){
                canPlay = true;
                break;
            }
        }

        System.out.println(canPlay?"YES":"NO");
    }
}
