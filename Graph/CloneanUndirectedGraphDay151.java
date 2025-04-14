class Solution {
    private Node dfs(Node node, Set<Node> vis) {
        vis.add(node);
        Node copyNode=new Node(node.val);
        for(Node neighbour:node.neighbors) {
            if(!vis.contains(neighbour)) copyNode.neighbors.add(dfs(neighbour,vis));
        } 
        
        return copyNode;
    }
    Node cloneGraph(Node node) {
        // code here
        Set<Node> vis=new HashSet<>();
        return dfs(node,vis);
    }
}
