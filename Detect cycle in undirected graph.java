class Solution {
    static class Pair {
        int node;
        int parent;
        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    public boolean checkForCycle(int src, int V, ArrayList<ArrayList<Integer>> adj, boolean []vis){
        vis[src] = true;
        Queue <Pair>q = new LinkedList<>();
        q.add(new Pair(src, -1));
        while(!q.isEmpty()){
            int node = q.peek().node;
            int parent = q.peek().parent;
            q.remove();
            
            for(int adjacentNode: adj.get(node)){
                if(vis[adjacentNode] == false){
                    vis[adjacentNode] = true;
                    q.add(new Pair(adjacentNode,node));
                }else if(parent != adjacentNode){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Code here
        boolean vis[] = new boolean[V];
        for(int i = 0; i<V; i++) vis[i] =false;
        for(int i = 0; i<V; i++) {
            if(vis[i] == false){
                if(checkForCycle(i,V,adj, vis))return true;
            }
        }
        return false;
    }
}
