package DIV2_EDU_65;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class C {

    static int MAX = (int) (5*10e5+2);
    static ArrayList<Integer>[] g;
    static boolean seen[];
    static int components[];
    static HashMap<Integer, Integer> compOwn;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        g = new ArrayList[MAX];
        seen = new boolean[MAX];
        components = new int[MAX];
        compOwn = new HashMap();

        for(int i = 0; i < m; i++) {
            int numf = scan.nextInt();
            int groupFriends[] = new int[numf];
            for(int j = 0; j < numf; j++) groupFriends[j] = scan.nextInt();
            for(int k = 0; k < numf; k++) {
                for(int p = 0; p < numf; p++) {
                    if(k!=p){
                        if(g[groupFriends[k]] == null) g[groupFriends[k]] = new ArrayList<>();
                        g[groupFriends[k]].add(groupFriends[p]);
                    }
                }
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
