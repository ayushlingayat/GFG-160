import java.util.ArrayDeque;
import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class LevelOrderTraversalDay80 {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int len = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            
            while (len-- > 0) {
                Node current = q.poll();
                level.add(current.data);
                
                if (current.left != null)
                    q.offer(current.left);
                
                if (current.right != null)
                    q.offer(current.right);
            }
            ans.add(level);
        }
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        LevelOrderTraversalDay80 traversal = new LevelOrderTraversalDay80();
        ArrayList<ArrayList<Integer>> result = traversal.levelOrder(root);
        
        System.out.println("Level Order Traversal: " + result);
    }
}
