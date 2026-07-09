class Solution {
    
    // DFS APPROACH
    
    static void dfs(int node , ArrayList<ArrayList<Integer>> adj,boolean [] vis  ){
        vis[node] = true;
        
        for(int neigh : adj.get(node)){
            if(!vis[neigh]){
                dfs(neigh, adj,vis);
            }
        }
    }
    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);   // Undirected graph
        }
        // code here
        boolean [] vis = new boolean[V];
        int cnt = 0;
        
        for(int i = 0; i<V; i++){
            if(!vis[i]){
                cnt++;
                dfs(i,adj,vis);
            }
        }
        return cnt;
    }
}


// BFS APPROACH

class Solution {
    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {

        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[V];
        int cnt = 0;

        for (int i = 0; i < V; i++) {

            if (!vis[i]) {

                cnt++;

                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                vis[i] = true;

                while (!q.isEmpty()) {

                    int node = q.poll();

                    for (int neigh : adj.get(node)) {

                        if (!vis[neigh]) {
                            vis[neigh] = true;
                            q.offer(neigh);
                        }
                    }
                }
            }
        }

        return cnt;
    }
}

// DSU APPROACH

class Solution {

    class DisjointSet {
        int[] parent;
        int[] rank;

        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int findParent(int node) {
            if (parent[node] == node)
                return node;

            return parent[node] = findParent(parent[node]);
        }

        void unionByRank(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);

            if (pu == pv)
                return;

            if (rank[pu] < rank[pv]) {
                parent[pu] = pv;
            } else if (rank[pv] < rank[pu]) {
                parent[pv] = pu;
            } else {
                parent[pv] = pu;
                rank[pu]++;
            }
        }
    }

    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {

        DisjointSet ds = new DisjointSet(V);
        int components = V;

        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            if (ds.findParent(u) != ds.findParent(v)) {
                ds.unionByRank(u, v);
                components--;
            }
        }

        return components;
    }
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
