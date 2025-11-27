package GRAPH;

// import java.util.*;

public class DisjointSet {
    private int[] parent;
    private int[] rank;
    private int[] size;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }

    public int findUltimateParent(int node) {
        if (node == parent[node]) return node;
        return parent[node] = findUltimateParent(parent[node]); // path compression
    }

    // *******************************
    //  UNION BY RANK
    // *******************************
    public int unionByRank(int u, int v) {
        int pu = findUltimateParent(u);
        int pv = findUltimateParent(v);

        if (pu == pv) return 0;

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
        return 1;
    }

    // *******************************
    //  UNION BY SIZE  (Corrected)
    // *******************************
    public int unionBySize(int u, int v) {
        int pu = findUltimateParent(u);
        int pv = findUltimateParent(v);

        if (pu == pv) return 0;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        return 1;
    }


    // ***********************************
    // TESTING
    // ***********************************
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(10);

        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);

        ds.unionBySize(4, 5);
        ds.unionBySize(5, 6);

        System.out.println(ds.findUltimateParent(1)); // parent of set {1,2,3}
        System.out.println(ds.findUltimateParent(4)); // parent of set {4,5,6}
    }
}
