class Solution {
   static class Pair{
        int distance;
        int node;
        
        Pair(int distance, int node){
            this.distance = distance;
            this.node = node;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<int[]>>adj = new ArrayList<>();
        for(int i =0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int [] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            
        adj.get(u).add(new int[]{v, w});
        adj.get(v).add(new int[]{u, w});
        }
        
        PriorityQueue<Pair>pq = new PriorityQueue<Pair>((x,y)->x.distance-y.distance);
        int [] dist = new int [V];
        for(int i = 0; i<V; i++){
            dist[i] = (int)(1e9);
        }
        
        dist[src] = 0;
        pq.add(new Pair(0,src));
        
        while(pq.size() != 0){
            Pair top = pq.poll();
            int currDist = top.distance;
            int node = top.node;
          
            for (int[] it : adj.get(node)) {
                int adjNode = it[0];
                int edgeWeight = it[1];

                if (currDist + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = currDist + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}
        
