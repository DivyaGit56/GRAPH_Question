class Pair{
    int weight;
    int node;
    public Pair( int node,int weight){
        this.node = node;
        this.weight = weight;
    }
}

class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Pair>>adj = new ArrayList<>();
        
        for(int i= 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int []e:edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        
        PriorityQueue<Pair>pq = new PriorityQueue<Pair>((x,y)->x.weight-y.weight);
        int []vis = new int[V];
        pq.add(new Pair(0,0));
        
        int sum = 0;
        while(!pq.isEmpty()){
            
        Pair cur = pq.poll();
            int node = cur.node;
            int wt = cur.weight;
            
            if (vis[node] == 1) continue;
            vis[node] = 1;
            sum += wt;
            
            for (Pair it : adj.get(node)) {
                if (vis[it.node] == 0) {
                    pq.add(new Pair(it.node, it.weight));
                }
            }
        }
        return sum;
        
    }
}
