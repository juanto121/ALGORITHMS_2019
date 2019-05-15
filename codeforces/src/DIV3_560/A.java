package DIV3_560;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String desc[] = scan.nextLine().split(" ");
        int n = Integer.parseInt(desc[0]);
        int x = Integer.parseInt(desc[1]);
        int y = Integer.parseInt(desc[2]);
        String num = scan.nextLine();
        String numToFlip = num.substring(n-x, n);
        int count = 0;
        for(int i = numToFlip.length() - 1; i >= 0; i--) {
            if(numToFlip.length()-1-i == y){
                if(numToFlip.charAt(i) == '0') count++;
            }else{
                if(numToFlip.charAt(i) == '1') count++;
            }
        }
        System.out.println(count);
    }
}
