class Solution {
    public int sumK(Node root, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        return solve(root,0,map,k);
    }
    int solve(Node node,int cur,Map<Integer,Integer> map,int k){
        if(node==null)  return 0;
        
        cur += node.data;
        int ans = map.getOrDefault(cur-k,0);
        
        map.merge(cur,1,Integer::sum);
        ans += solve(node.left,cur,map,k);
        ans += solve(node.right,cur,map,k);
        map.merge(cur,-1,Integer::sum);
        
        return ans;
    }
}
