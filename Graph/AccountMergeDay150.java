import java.util.*;

class Solution {
    static class DisjointSet {
        int[] parent;

        DisjointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) parent[py] = px;
        }
    }

    static ArrayList<ArrayList<String>> accountsMerge(ArrayList<ArrayList<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> emailToAccount = new HashMap<>();

        // Step 1: Union accounts with common emails
        for (int i = 0; i < n; i++) {
            ArrayList<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailToAccount.containsKey(email)) {
                    ds.union(i, emailToAccount.get(email));
                } else {
                    emailToAccount.put(email, i);
                }
            }
        }

        // Step 2: Group emails by their representative
        Map<Integer, TreeSet<String>> merged = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToAccount.entrySet()) {
            String email = entry.getKey();
            int parent = ds.find(entry.getValue());
            merged.computeIfAbsent(parent, k -> new TreeSet<>()).add(email);
        }

        // Step 3: Build the merged account list
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, TreeSet<String>> entry : merged.entrySet()) {
            int index = entry.getKey();
            String name = accounts.get(index).get(0);
            ArrayList<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(entry.getValue());
            result.add(account);
        }

        return result;
    }
}
