class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int v = adj.size();  
        ArrayList<Integer>bfs = new ArrayList<>();
        Queue<Integer>q = new LinkedList<>();
        boolean[]visited = new boolean [v];
        
        q.add(0);
        visited[0] = true;
        
        while(! q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);
            
            for(Integer it : adj.get(node)){
            if(visited[it] == false){
                visited[it] = true;
                q.add(it);
            }
        }
    }
    return bfs;
    }
}
