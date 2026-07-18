class Solution {
    
    public boolean check(int start, int V,int[]color,ArrayList<ArrayList<Integer>>adj){
      Queue<Integer>q = new LinkedList<>();
      q.add(start);
        color[start] = 0;
        
        while(!q.isEmpty()){
            int node =q.peek();
            q.remove();
            
            for(int it:adj.get(node)){
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
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        
        int []color = new int[V];
        
        for(int i = 0; i<V; i++){
            color[i] = -1;
        }
        
        for(int i= 0; i<V; i++){
            if(color[i] == -1){
                if(check(i,V,color,adj) == false){
                    return false;
                }
            }
        }
        return true;
    }
}
