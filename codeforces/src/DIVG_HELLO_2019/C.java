package DIVG_HELLO_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C {

    static boolean g[][];
    static boolean seen[];
    static int matchL[];
    static int matchR[];

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bfr.readLine());
        int sq[] = new int[n];


        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        int cntz = 0;

        for(int i = 0; i < n; i++) {
            sq[i] = count(bfr.readLine());
            if(sq[i] == 10_000_005) continue;
            if(sq[i] > 0){
                pos.add(sq[i]);
            }
            else
                neg.add(sq[i]);
            if(sq[i] == 0){
                cntz++;
            }
        }

        int cng = neg.size();
        int cp = pos.size();


        g= new boolean[cp][cng];
        seen = new boolean[cng];
        matchL = new int[cp];
        matchR = new int[cng];

        Arrays.fill(matchL, -1);
        Arrays.fill(matchR, -1);

        for(int i = 0; i < cp; i++){
            for(int j = 0; j < cng; j++) {
                if(pos.get(i) == -neg.get(j)){
                    g[i][j] = true;
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < cp; i++){
            Arrays.fill(seen, false);
            if(bpm(i, cng)) cnt++;
        }

        System.out.println(cnt+cntz/2);
    }

    private static boolean bpm(int u, int n) {
        for(int v = 0; v < n; v++){
            if(g[u][v]){
                if(seen[v]) continue;
                seen[v] = true;
                if(matchR[v] < 0 || bpm(matchR[v], n)){
                    matchL[u] = v;
                    matchR[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    private static int count(String line) {
        int len = line.length();
        Stack<String> q = new Stack<>();
        int sum = 0;
        q.push(String.valueOf(line.charAt(0)));
        for(int i = 1; i < len; i++){
            String c = String.valueOf(line.charAt(i));
            if (!q.empty() && q.peek().equals("(") && c.equals(")")) {
                q.pop();
            }else{
                q.push(c);
            }
        }
        int left = 0;
        int right = 0;

        for(String s: q){
            if(s.equals("(")) left++;
            if(s.equals(")")) right++;
        }

        if(left > 0 && right>0){
            return 10_000_005;
        }else{
            sum = left-right;
        }

        return sum;
    }
}
