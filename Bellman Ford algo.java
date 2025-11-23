class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {

        int[] dist = new int[V];

        // Step 1: Initialize distances
        for (int i = 0; i < V; i++) {
            dist[i] = (int) 1e8;
        }
        dist[src] = 0;

        // Step 2: Relax edges V-1 times
        for (int i = 1; i <= V - 1; i++) {
            for (int[] e : edges) {
                int u = e[0];
                int v = e[1];
                int wt = e[2];

                if (dist[u] != (int)1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Step 3: Check for negative cycle
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];

            if (dist[u] != (int)1e8 && dist[u] + wt < dist[v]) {
                return new int[]{-1};
            }
        }

        return dist;
    }
}

