class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int countPaths(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Pair>>adj = new ArrayList<>();
        
        for(int i =0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int []e :edges){
            int u = e[0];
            int v= e[1];
            int t= e[2];
            
            adj.get(u).add(new Pair(v,t));
            adj.get(v).add(new Pair(u,t));
        }
        
        PriorityQueue<Pair>pq = new PriorityQueue<Pair>((x,y)->x.first-y.first);
        
        int []dist = new int [V];
        int []ways = new int [V];
        
        for(int i =0; i<V; i++){
            dist[i] = (int)(1e9);
            ways[i] = 0;
        }
        
        dist[0] = 0;
        ways[0] =1;
        pq.add(new Pair(0,0));
        int mod = (int)(1e9+7);
        while(!pq.isEmpty()){
            int dis = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();
            
            for(Pair it:adj.get(node)){
                int adjNode = it.first;
                int edis = it.second;
                
                if(dis+edis <dist[adjNode]){
                    dist[adjNode] = dis+edis;
                    pq.add(new Pair(dis+edis, adjNode));
                    ways[adjNode] = ways[node];
                }
                else if(dis+edis == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node]%mod);
                }
            }
        }
        
        return ways[V-1]%mod;
        
    }
}
