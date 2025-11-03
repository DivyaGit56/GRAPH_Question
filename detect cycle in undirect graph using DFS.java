class Solution{
    private boolean dfs(int node, int parent, int vis[], ArrayList<ArrayList<Integer>>adj){
        vis[node] =1;
        for(int adjacentNode : adj.get(node)){
            if(vis[adjacentNode] == 0){
                if(dfs(adjacentNode, node, vis, adj)== true)return true;
            }else if(adjacentNode != parent) return true;
        }
        return false;
    }
    
    public boolean isCycle(int V, int [][]edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
         for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

         for (int[] edge : edges) {
             int u = edge[0];
             int v = edge[1];
             adj.get(u).add(v);
             adj.get(v).add(u);
         }
        int vis[] = new int [V];
        for(int i = 0; i<V; i++){
            if(vis[i] == 0){
            if(dfs(i,-1,vis,adj) == true)return true;
            }
        }
        return false;
    }
}
