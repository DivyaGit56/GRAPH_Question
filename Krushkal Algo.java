class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }

    public int compareTo(Edge other) {
        return this.weight - other.weight;   // ascending order
    }
}

class DisjointSet {
    int parent[], size[];

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findUPar(int node) {
        if (parent[node] == node) return node;
        return parent[node] = findUPar(parent[node]);
    }

    void unionBySize(int u, int v) {
        int pu = findUPar(u);
        int pv = findUPar(v);

        if (pu == pv) return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}

class Solution {
    public int spanningTree(int V, int[][] edges) {

        // Step 1: Convert edges into list of Edge objects
        ArrayList<Edge> edgeList = new ArrayList<>();
        for (int[] e : edges) {
            edgeList.add(new Edge(e[0], e[1], e[2]));
        }

        // Step 2: Sort edges by weight
        Collections.sort(edgeList);

        // Step 3: Apply Kruskal
        DisjointSet ds = new DisjointSet(V);
        int mstWt = 0;

        for (Edge e : edgeList) {
            if (ds.findUPar(e.src) != ds.findUPar(e.dest)) {
                mstWt += e.weight;
                ds.unionBySize(e.src, e.dest);
            }
        }

        return mstWt;
    }
}
