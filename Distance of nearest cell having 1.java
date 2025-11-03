class Node{
    int first;
    int second;
    int third;
    Node(int _first, int _second,int _third){
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}
class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        
        
       Queue<Node>q = new LinkedList<>();
        for(int i =0; i<n; i++){
            for(int j = 0; j<m; j++){

                if(grid[i][j] == 1){
                    q.add(new Node(i, j, 0));
                    vis[i][j] = 1;
                }else{
                    vis[i][j] =0;
                }
            }
        }
        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = { 0, +1, 0, -1};

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.remove();
            dist[row][col] = steps;

            for(int i=0; i<4;i++){
                int nrow = row+delRow[i];
                int ncol = col+delCol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol] == 0 ){
                    vis[nrow][ncol] =1;
                    q.add(new Node (nrow, ncol, steps+1));
                }
            }

        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                temp.add(dist[i][j]);
            }
            ans.add(temp);
        }


        return ans;
    }
}
