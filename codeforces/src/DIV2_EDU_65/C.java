package DIV2_EDU_65;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class C {

    static ArrayList<Integer>[] g;
    static boolean seen[];
    static int components[];
    static HashMap<Integer, Integer> compOwn;


    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String nm[] = bfr.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        g = new ArrayList[n+1];
        seen = new boolean[n+1];
        components = new int[n+1];
        compOwn = new HashMap();

        for(int i = 0; i < m; i++) {
            StringTokenizer str = new StringTokenizer(bfr.readLine());
            int numf = Integer.parseInt(str.nextToken());
            int groupFriends[] = new int[numf];
            ArrayList<Integer> friends = new ArrayList<>();
            for(int j = 0; j < numf; j++) {
                int f = Integer.parseInt(str.nextToken());
                friends.add(f);
                groupFriends[j] = f;
            }
            for(int k = 0; k < numf; k++) {
                if(g[groupFriends[k]] == null) g[groupFriends[k]] = friends;
                else g[groupFriends[k]].addAll(friends);
            }
        }

        int count[] = new int[n];
        int componenti = 0;
        for(int i = 1; i <= n; i++) {
            if(!seen[i]) {
                dfs(i, componenti);
                componenti++;
            }
        }

        for(int i = 1; i <= n; i++) {
            System.out.print(components[compOwn.get(i)] + " ");
        }

    }

    private static void dfs(int i, int componenti) {
        seen[i] = true;
        compOwn.put(i, componenti);
        components[componenti]++;
        ArrayList<Integer> list = g[i];
        if(list != null) {
            int len = list.size();
            for (int v = 0; v < len; v++) {
                int b = g[i].get(v);
                if (!seen[b]) {
                    dfs(b, componenti);
                }
            }
        }
    }
}
