class Solution {
    public boolean isPossible(int N, int P, int[][] prerequisites) {
        
        // Your Code goes here
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i = 0; i<N; i++){
            adj.add( new ArrayList<>());
            
        }
        for(int [] p :prerequisites ){
            int u = p[0];
            int v = p[1];
            
            adj.get(v).add(u);
        }
        
        int indegree[] = new int[N];
        for(int i = 0; i<N; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer>q = new LinkedList<>();
        for(int i= 0; i<N; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        List<Integer>topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            
            for(int it : adj.get(node)){
                indegree[it]--;
                
                if(indegree[it] == 0)q.add(it);
            }
        }
        if(topo.size() == N)return true;
        return false;
        
        
    }
}
