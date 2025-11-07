class Solution {
    
    private boolean check(int start, int V, List<List<Integer>>adj, int[]color){
        Queue<Integer>q = new LinkedList<Integer>();
        q.add(start);
        color[start] = 0;
        
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            
            
            for(int it : adj.get(node)){
                if(color[it] == -1){
                    color[it] = 1-color[node];
                    q.add(it);
                }
                else if(color[it] == color[node]){
                    return false;
                }
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
                if(check(i,V, adj,color) == false ){
                    return false;
                }
            }
        }
        return true;
        
    }
}
