import java.util.*;
class Solution {
    class Pair{
        int weight;
        int node;
        Pair(int weight, int node){
            this.weight = weight;
            this.node = node;
        }
    }
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        ArrayList<ArrayList<Pair>>adj = new ArrayList<>();
      
        for(int i = 0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int []e:edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            
            adj.get(u).add(new Pair(w,v));
            adj.get(v).add(new Pair(w,u));
        }
        
        PriorityQueue<Pair>pq = new PriorityQueue<Pair>((x,y)->x.weight-y.weight);
        int []dist = new int[n+1];
        int []Parent = new int [n+1];
        
        for(int i = 0; i<=n;i++){
            dist[i] = (int)(1e9);
            Parent[i]=i;
        }
        dist[1] = 0;
        pq.add(new Pair(0,1));
        
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            int node = top.node;
            int dis = top.weight;
            
            for(Pair iter:adj.get(node)){
                int adjNode = iter.node;
                int edw = iter.weight;
                
                if(dis+edw<dist[adjNode]){
                    dist[adjNode] = dis+edw;
                    pq.add(new Pair(dis+edw,adjNode));
                    Parent[adjNode] = node;
                }
            }
        }
        List<Integer>path = new ArrayList<>();
        if(dist[n] ==(int) 1e9){
            path.add(-1);
            return path;
        }
        int node = n;
        while(Parent[node] != node){
            path.add(node);
            node = Parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        List<Integer> ans = new ArrayList<>();
        ans.add(dist[n]);  // total weight
        ans.addAll(path);
        return ans;
    }
}
