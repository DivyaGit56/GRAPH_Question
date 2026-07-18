class Solution {
    
    private boolean dfs(int node, int col,int[]color, List<List<Integer>>adj){
        
        color[node] = col;
        
        
            
            for(int it : adj.get(node)){
                if(color[it] == -1){
                   if(dfs(it,1-col,color, adj) == false)return false;
                }else if(color[it] == col){
                    return false;
                }
            }
            return true;
    }
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        //  Build Adjacency list
        List<List<Integer>>adj = new ArrayList<>();
        
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
            
        }
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int color[] = new int [V];
        for(int i = 0; i<V; i++) color[i] =-1;
        
        for(int i = 0; i<V; i++){
            if(color[i] == -1){
                if(dfs(i,0,color, adj) == false ){
                    return false;
                }
            }
        }
        return true;
        
    }
}
