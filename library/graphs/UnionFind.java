import java.util.Arrays;

public class UnionFind {
    public static void main(String[] args) {
        int n = 7;
        int parent[] = new int[n+1];
        int size[] = new int[n+1];

        // Initialize the tree roots to be each element.
        // initialize size as 1 element for each tree.
        initialize(parent, size);

        //elements indexed from 1, extra element at position 0 can be discarded.
        union(parent, size,5,2);
        union(parent, size,4, 5);
        union(parent, size,2, 1);
        union(parent, size,7, 6);

        for(int i = 1; i <= n; i++) {
            System.out.print(size[root(parent, i)] + " ");
        }
    }

    private static void initialize(int[] parent, int[] size) {
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // returns the root/parent element for node u
    private static int root(int parent[], int u) {
        while(parent[u] != u) {
            u = parent[u];
        }
        return u;
    }

    // returns true if U and V are connected
    private static boolean find(int[] parent, int u, int v) {
        return root(parent, u) == root(parent, v);
    }

    // O(N2) implementation just for reference
    private static void union(int parent[], int size[], int u, int v) {
        int parentOfU = root(parent, u);
        int parentOfV = root(parent, v);
        parent[parentOfU] = parentOfV;
        size[parentOfV] += size[parentOfU];
    }

}
