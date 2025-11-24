class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        int n = dist.length;
        int INF = (int)1e9;
        
        for(int i =0; i<n; i++){
            for(int j = 0; j<n; j++){
                // if no direct edge
                if(dist[i][j] == -1){
                    dist[i][j] = INF;
                    
                }
                if(i == j)dist[i][j] =0;
            }
        }
        
        // finding shortest path
        
        for(int k =0; k<n; k++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n;j++){
                     if (dist[i][k] != INF && dist[k][j] != INF) {
                    dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        }
        // to detect -ve cycle
        for (int k=0; k<n; k++){
    if(dist[k][k] < 0){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (dist[i][k] != INF && dist[k][j] != INF) {
                dist[i][j] = -1;
                }
            }
        }
    
    }
}

        for(int i =0; i<n; i++){
            for(int j =0;j<n; j++){
                if(dist[i][j] == (int)(1e9)){
                    dist[i][j] =-1;
                }
            }
        }
    }
}

