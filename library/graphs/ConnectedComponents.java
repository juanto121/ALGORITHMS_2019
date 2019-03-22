import java.util.ArrayList;

public class ConnectedComponents {
  public static void main(String[] args) {
    Graph g = new Graph(4);

    g.addVertex(0, 1);
    g.addVertex(1,2);

    System.out.println(g.findConnectedComponents());
  }
}

// Undirected Graph with vertices labeled from 0 to size
class Graph {

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


  public int findConnectedComponents() {
    int connectedComponentsCount = 0;
    for(int i = 0; i < size; i++){
      if(!seen[i]) {
        connectedComponentsCount++;
        dfs(i);
      }
    }
    return connectedComponentsCount;
  }

  private void dfs(int u) {
    seen[u] = true;
    for(int i = 0; i < g[u].size(); i++){
      int v = g[u].get(i);
      if(!seen[v]) dfs(v);
    }
  }
}
