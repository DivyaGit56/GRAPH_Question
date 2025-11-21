class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}

class Tuple{
    int first,second, third;
    Tuple(int first,int second,int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>>adj = new ArrayList<>();
        for(int i =0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[]f:flights){
            int u = f[0];
            int v = f[1];
            int c = f[2];

            adj.get(u).add(new Pair(v,c));
        }
        Queue<Tuple>q = new LinkedList<>();
        q.add(new Tuple(0,src,0));
        int[]costs = new int[n];

        for(int i=0; i<n;i++){
            costs[i] = (int)(1e9);
        }
        costs[src] = 0;
        while(!q.isEmpty()){
            Tuple it = q.peek();
            q.remove();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            if(stops>k)continue;
            for(Pair iter: adj.get(node)){
                int adjNode = iter.first;
                int ecost = iter.second;

                if(cost+ecost<costs[adjNode] && stops <= k){
                    costs[adjNode] = cost+ecost;

                    q.add(new Tuple(stops+1, adjNode, cost +ecost));
                }
            }
        }
        if(costs[dst] == (int)(1e9)) return -1;
        return costs[dst];
        
    }
}
