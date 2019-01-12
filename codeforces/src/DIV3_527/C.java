package DIV3_527;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        StringBuilder stb = new StringBuilder(2*n-2);
        int linelens[] = new int[n-1];

        for(int i = 0; i < 2*n-2; i++){
            String line = scan.nextLine();
            int linelen = line.length() - 1;

            if(linelens[linelen] == 0){
                stb.append("S");
            }else{
                stb.append("P");
            }

            linelens[linelen] ++;
        }

        System.out.println(stb.toString());
    }
}
