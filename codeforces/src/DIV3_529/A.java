package DIV3_529;

import java.util.Scanner;

public class A {

    static int lenMap[] = new int[55 + 2];

    public static void main(String[] args) {

        for(int i = 0; i < 57; i++){
            lenMap[i] = (i*i+i)/2;
        }

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String s = scan.nextLine();
        int originalLen = 0;

        for(int i = 0; i < 57; i++) {
            if(n==lenMap[i]){
                originalLen = i;
            }
        }

        StringBuilder stb = new StringBuilder(originalLen);
        int index = originalLen;
        int sp = n;
        while(true) {
            stb.append(s.charAt(sp-index));
            if(sp-index == 0) break;
            sp-=index;
            index--;
        }

        System.out.println(stb.reverse().toString());
    }
}
