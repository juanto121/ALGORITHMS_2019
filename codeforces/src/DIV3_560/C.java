package DIV3_560;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        char s[] = scan.nextLine().toCharArray();
        int lengthGoodString = 1;
        boolean selected[] = new boolean[n];

        char last = s[0];
        int lastIndex = 0;

        for(int i = 1; i < s.length; i++) {
            if(s[i] != last){
                selected[i] = true;
                selected[lastIndex] = true;
                lengthGoodString++;
                if(i+1 < s.length){
                    last=s[i+1];
                    lastIndex = i+1;
                }
            }
        }

        if(lengthGoodString == 1){
            System.out.println(String.format("%d%n%s", n, ""));
        }else{
            StringBuilder stb = new StringBuilder();
            for(int i = 0; i < n; i++) {
                if(selected[i]) {
                    stb.append(s[i]);
                }
            }
            System.out.println(String.format("%d%n%s",n-stb.length(), stb.toString()));
        }
    }
}
