package DIV2_548;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class C {

  static long MOD = 1_000_000_000L + 7;

  public static void main(String[] args) {
    // Figure out the size of connected components and subtract that from n^k
    Scanner scan = new Scanner(System.in);
    int desc[] = toIntArr(scan.nextLine().split(" "));
    int n = desc[0];
    int k = desc[1];
    Graph g = new Graph(n);
    for(int i = 0; i < n-1; i++){
      int []edged = toIntArr(scan.nextLine().split(" "));
      int u = edged[0]-1;
      int v = edged[1]-1;
      int color = edged[2];
      if(color == 0){
        g.addVertex(u,v);
      }
    }

    long pow = 1;
    for(int i = 0; i < k; i++){
      pow = (pow % MOD) * (n % MOD);
    }
    long total = pow % MOD;
    long cc = g.findConnectedComponents(k);

    System.out.println( (total - cc + MOD) % MOD);
  }

  private static int[] toIntArr(String a[]) {
    return Arrays.stream(a).mapToInt(Integer::parseInt).toArray();
  }
}


// Undirected Graph with vertices labeled from 0 to size
class Graph {

  long MOD = 1_000_000_000L + 7;
  ArrayList<Integer>[] g;
  boolean seen[];
  int size = 0;

  public Graph(int numVertex){
    g = new ArrayList[numVertex];
    seen = new boolean[numVertex];
    size = numVertex;
    for(int i = 0; i < size; i++) g[i] = new ArrayList<>();
  }

  public void addVertex(int u, int v) {
    g[u].add(v);
    g[v].add(u);
  }


  public long findConnectedComponents(int k) {
    long ccSum = 0;
    for(int i = 0; i < size; i++){
      if(!seen[i]) {
        int size = dfs(i);
        long pow = 1;
        for(int j = 0; j < k; j++){
          pow = ((pow % MOD) * (size % MOD)) % MOD;
        }
        ccSum = (ccSum % MOD) + (pow%MOD) % MOD;
      }
    }
    return ccSum;
  }

  private int dfs(int u) {
    seen[u] = true;
    int sum = 0;
    for(int i = 0; i < g[u].size(); i++){
      int v = g[u].get(i);
      if(!seen[v]){
        sum += dfs(v);
      }
    }
    return 1 + sum;
  }
}
