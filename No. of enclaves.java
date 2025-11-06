class Solution {

    public void dfs(int row, int col, int[][]vis, int[][]grid, int[]delrow, int []delcol){

        int n = grid.length;
        int m = grid[0].length;

        vis[row][col] = 1;

        for(int i = 0; i<4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow >= 0 && nrow < n && ncol>= 0 && ncol <m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                dfs(nrow, ncol, vis , grid, delrow, delcol);
            }
        }

    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int [n][m];
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};


        // traverse first and last row

        for(int i = 0; i<m; i++){
            // first row
            if(vis[0][i] == 0 && grid[0][i] ==1){
                dfs(0,i,vis, grid, delrow,delcol);
            }
            // last col
            if(vis[n-1][i] == 0 && grid[n-1][i] == 1){
                dfs(n-1,i,vis, grid, delrow,delcol);

            }
        }
        // first col and last col
        for(int j = 0; j<n; j++){
            // first row
            if(vis[j][0] == 0 && grid[j][0] ==1){
                dfs(j,0,vis, grid, delrow,delcol);
            }
            // last col
            if(vis[j][m-1] == 0 && grid[j][m-1] == 1){
                dfs(j,m-1,vis, grid, delrow,delcol);

            }
        }
         int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m;j++){
                if(vis[i][j] ==0 && grid[i][j] == 1){
                    count++;
                }
            }
        }


     return count;
        
    }
}
