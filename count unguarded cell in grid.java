class Solution{
    public void dfs(int row, int col, int [][]grid,int drow[], int dcol[] ){
        for(int i = 0; i<4; i++){
            int nrow = row+drow[i];
            int ncol = col+dcol[i];
            while(nrow >=0 && nrow<grid.length && ncol >=0 &&ncol<grid[0].length){
                if (grid[nrow][ncol] == 2 || grid[nrow][ncol] == 3) break;
                if (grid[nrow][ncol] == 0) grid[nrow][ncol] = 1;

                nrow += drow[i];
                ncol += dcol[i];
            }
        }

    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int [][] grid = new int[m][n];
      
               // marks guard position
                        for(int [] guard : guards){
                             int i = guard[0];
                            int j = guard[1];
                             grid [i][j] = 2;
                        }

         // marks wall position
         for(int [] wall : walls){
             int i = wall[0];
             int j = wall[1];

            grid[i][j] = 3;
        }
        // marking cell is to be guarded by guard
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        for(int [] guard : guards){
            int i = guard[0];
            int j = guard[1];

        
        dfs(i,j, grid, drow, dcol);
        }
        int count = 0;
         for(int i = 0; i<m; i++){
             for(int j = 0; j<n; j++){
                 if(grid[i][j] == 0)count++;
                 }
           }
        return count;

    }

}
