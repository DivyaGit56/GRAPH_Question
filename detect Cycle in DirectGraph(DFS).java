class Solution {
    
    private boolean dfsCheck(int node, List<List<Integer>>adj, int vis[], int pathVis[]){
        vis[node] = 1;
        pathVis[node] =1;
        
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                if(dfsCheck(it, adj, vis, pathVis) == true)return true;
            }else if(pathVis[it] == 1) return true;
        }
        pathVis[node] = 0;
        return false;
        
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        
    
         List<List<Integer>>adj = new ArrayList<>();
        
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
            
        }
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            
            adj.get(u).add(v);
            // adj.get(v).add(u);
        }
        
    
    
    int vis[] = new int[V];
    int pathVis[] = new int[V];
    
    for(int i = 0; i<V; i++){
        if(vis[i] == 0){
            if(dfsCheck(i, adj, vis, pathVis) == true)return true;
        }
    }
    return false;
    }
}
