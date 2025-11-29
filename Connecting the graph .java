class DisjointSet {
    int[] parent,size;

    DisjointSet(int n) {
        parent = new int[n];
        
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            
            size[i] = 1;
        }
    }

    int find(int node) {
        if (parent[node] == node) return node;
        return parent[node] = find(parent[node]); // path compression
    }

    

    void unionBySize(int u, int v) {
        int pu = find(u);
        int pv = find(v);
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

    public int Solve(int n, int[][] edge) {
        // Code here
        DisjointSet ds = new DisjointSet(n);
        
        int ExtraEdges = 0;
        int m = edge.length;
        
        for(int i =0; i<m; i++){
            int u= edge[i][0];
            int v = edge[i][1];
            
            if(ds.find(u) == ds.find(v)) ExtraEdges++;
            else ds.unionBySize(u,v);
        }
        int cntComp = 0;
        for(int i=0; i<n; i++){
            if(ds.parent[i] == i)cntComp++;
        }
        int ans = cntComp-1;
        if(ExtraEdges >= ans)return ans;
        return -1;
        
    }
}
