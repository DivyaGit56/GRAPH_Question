class DisjointSet {
    int[] parent, size;

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int node) {
        if (parent[node] == node) return node;
        return parent[node] = find(parent[node]); // path compression
    }

    

    void unionBySize(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String,Integer>mapMailNode = new HashMap<String,Integer>();
        for(int i=0; i<n; i++){
            for(int j =1; j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(mapMailNode.containsKey(mail) == false){
                    mapMailNode.put(mail,i);
                }else{
                    ds.unionBySize(i,mapMailNode.get(mail));
                }
            }
        }
        ArrayList<String>[]mergeMail = new ArrayList[n];
        for(int i=0; i<n; i++)
            mergeMail[i] = new ArrayList<>();
            for(Map.Entry<String,Integer>entry:mapMailNode.entrySet()){
                String mail = entry.getKey();
                int parent = ds.find(entry.getValue());
                mergeMail[parent].add(mail);
            }
        
        List<List<String>>ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(mergeMail[i].size() == 0)continue;
            Collections.sort(mergeMail[i]);
            List<String>temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it:mergeMail[i]){
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}
