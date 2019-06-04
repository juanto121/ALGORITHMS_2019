package DIV2_563;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt() + 1;
        int assignation[] = new int[n];
        int current = 1;
        for(int i = 2; i < n; i++) {
            if(assignation[i] == 0) {
                for (int j = 1; i * j < n; j++) {
                    assignation[i * j] = current;
                }
                current++;
            }
        }
        printa(assignation);
    }

    static private void printa(int[] a) {
        StringBuilder stb = new StringBuilder();
        for(int i = 2; i < a.length; i++){
            stb.append(a[i] + " ");
        }
        System.out.print(stb.toString());
    }
}
