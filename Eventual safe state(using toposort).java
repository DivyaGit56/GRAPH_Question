class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][]edges) {
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        
       for(int i = 0; i<V; i++){
           adj.add(new ArrayList<>());
       }        
       
       for(int[] e: edges){
           int u = e[0];
           int v = e[1];
           
           adj.get(u).add(v);
           
       }
       
       List<List<Integer>>adjRev = new ArrayList<>();
       for(int i = 0; i<V; i++){
           adjRev.add(new ArrayList<>());
       }
       int indegree[] = new int [V];
       for(int i = 0; i<V; i++){
           for(int it: adj.get(i)){
               adjRev.get(it).add(i);
               indegree[i]++;
           }
       }
       Queue<Integer>q = new LinkedList<>();
       ArrayList<Integer>safeNodes = new ArrayList<>();
       
       for(int i = 0; i<V; i++){
           if(indegree[i] == 0){
               q.add(i);
           } 
       }
       
       while(!q.isEmpty()){
           int node = q.poll();
           safeNodes.add(node);
           for(int it : adjRev.get(node)){
               indegree[it]--;
               if(indegree[it] == 0)q.add(it);
           }
          
       }
       Collections.sort(safeNodes);
       return safeNodes;
              
           }
       }
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
