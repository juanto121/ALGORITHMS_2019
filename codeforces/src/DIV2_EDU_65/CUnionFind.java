package DIV2_EDU_65;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CUnionFind {

    static int N = (int) (5*10e5+2);
    static int parent[];
    static int size[];

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String nm[] = bfr.readLine().split(" ");

        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        parent = new int[n+1];
        size = new int[n+1];

        for(int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

       for(int i = 0; i < m; i++) {
            StringTokenizer str = new StringTokenizer(bfr.readLine());
            int numf = Integer.parseInt(str.nextToken());
            int groupFriends[] = new int[numf];
            for(int j = 0; j < numf; j++) {
                groupFriends[j] = Integer.parseInt(str.nextToken());
            }
            for(int j = 1; j < numf; j++) {
                union(groupFriends[j], groupFriends[j-1]);
            }
        }

       for(int i = 1; i <= N; i++) {
           System.out.print(size[root(i)]+" ");
       }

    }

    static int root(int i) {
        while(parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    static void union(int u, int v) {
        int pu = root(u);
        int pv = root(v);
        parent[pu] = pv;
        size[pv] += size[pu];
    }
}
