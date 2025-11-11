class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // build adjacencyList
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            
            adj.get(u).add(v);
        }
        int indegree[] = new int[V];
        
        for(int i = 0; i<V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer>q = new LinkedList<>();
        for(int i = 0; i<V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        
        ArrayList<Integer>topo  = new ArrayList<>();
        // int i = 0;
        while(! q.isEmpty()){
            int node = q.peek();
            q.remove();
            
            topo.add(node);
            
            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        return topo;
    }
}
        
