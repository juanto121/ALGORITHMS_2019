package DIV3_527;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String st[] = scan.nextLine().split(" ");
        Integer students[] = new Integer[n];
        int index = 0;
        for(String s : st) {
            students[index++] = Integer.parseInt(s);
        }

        Arrays.sort(students);

        int diff = 0;
        for(int i = 1; i < n; i+=2){
            diff += students[i] - students[i-1];
        }

        System.out.println(diff);

    }

    public static void printarr(int[] arr){
        for(int a : arr){
            System.out.print(a + " ");
        }
        System.out.println("");
    }
}
