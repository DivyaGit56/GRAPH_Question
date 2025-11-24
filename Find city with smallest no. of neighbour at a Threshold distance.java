class Solution {
    int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        // code here
        int [][]dist = new int [n][n];
        
        //  fill with max value
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        //  if undirect assign both direction with same distance
        
        for(int i =0; i<m; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            
            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        
        // assign disgonal element with 0
        
        for(int i =0; i<n; i++) dist[i][i] =0;
        
        // floyd warshall to get  shortest dist btw every pair of vertex
        for(int k=0; k<n; k++){
            for(int i= 0; i<n;i++){
               for(int j =0; j<n; j++){
                   if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                       dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                   }
                
            }
        }
        }
        // find city with minimum  neighbour
        
        int cntCity = n;
        int cityNo = -1;
        for(int city =0;city<n; city++){
           int cnt = 0;
           for(int adjCity = 0; adjCity<n; adjCity++){
               if(dist[city][adjCity] <= distanceThreshold) cnt++;
           }
           if(cnt <= cntCity){
               cntCity = cnt;
               cityNo = city;
           }
        }
        return cityNo;
    }
}
