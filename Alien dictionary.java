class Solution {

    private List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int indegree[] = new int[V];

        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        List<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }

        return topo;
    }


    public String findOrder(String[] words) {
        int N = words.length;

        // Step 1: find all unique characters (K)
        boolean present[] = new boolean[26];
        for (String w : words) {
            for (char c : w.toCharArray()) {
                present[c - 'a'] = true;
            }
        }

        // Count K
        int K = 0;
        for (boolean b : present) {
            if (b) K++;
        }

        // Step 2: create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) adj.add(new ArrayList<>());


        // Step 3: Build graph
        for (int i = 0; i < N - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            int len = Math.min(s1.length(), s2.length());
            boolean found = false;

            for (int j = 0; j < len; j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if (c1 != c2) {
                    adj.get(c1 - 'a').add(c2 - 'a');
                    found = true;
                    break;
                }
            }

            // invalid: prefix case
            if (!found && s1.length() > s2.length()) return "";
        }

        // Step 4: Topological Sort
        List<Integer> topo = topoSort(26, adj);

        // Step 5: Build answer using only present characters
        StringBuilder ans = new StringBuilder();
        for (int it : topo) {
            if (present[it]) {
                ans.append((char) (it + 'a'));
            }
        }

        // If answer length != K → cycle / invalid
        if (ans.length() != K) return "";

        return ans.toString();
    }
}
