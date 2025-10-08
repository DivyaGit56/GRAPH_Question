class Solution {
    
    public static void DFS(int node,boolean[]vis, ArrayList<ArrayList<Integer>> adj,ArrayList<Integer>dfsl){
        vis[node] = true;
        dfsl.add(node);
        
        for(Integer it : adj.get(node)){
            if(vis[it] == false){
                DFS(it, vis, adj,dfsl);
            }
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int v = adj.size();
        ArrayList<Integer>dfsl = new ArrayList<>();
        boolean[]vis = new boolean[v];
        
        vis[0] = true;
        
        DFS(0,vis,adj,dfsl);
        return dfsl;
    }
}
