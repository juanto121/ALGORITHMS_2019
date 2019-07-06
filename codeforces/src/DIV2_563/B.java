package DIV2_563;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        PriorityQueue<Num> odds = new PriorityQueue<>();
        PriorityQueue<Num> evens = new PriorityQueue<>();
        Integer result[] = new Integer[n];

        for(int i = 0; i < n; i++) {
            int x = scan.nextInt();
            if(x % 2 == 0) evens.add(new Num(x, i));
            else odds.add(new Num(x, i));
            result[i] = x;
        }

        if (odds.isEmpty() || evens.isEmpty()) {
            printa(result);
        } else {
            Arrays.sort(result);
            printa(result);
        }

    }

    static private void printa(Integer[] a) {
        StringBuilder stb = new StringBuilder();
        for(int x: a){
            stb.append(x + " ");
        }
        System.out.print(stb.toString());
    }

    static private void printq(PriorityQueue<Num> q) {
        StringBuilder stb = new StringBuilder();
        while(!q.isEmpty()) {
            stb.append(q.poll().value + " ");
        }
        System.out.print(stb.toString());
    }
}

class Num implements Comparable<Num>{
    int value;
    int idx;
    Num(int val, int index){
        value = val; idx = index;
    }

    @Override
    public int compareTo(Num o) {
        return this.value - o.value;
    }
}