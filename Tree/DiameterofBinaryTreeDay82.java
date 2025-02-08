public class DiameterofBinaryTreeDay82 {

    // Node class representing each node of the binary tree
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    int fans = 0;

    // Method to calculate depth and update the diameter
    int depth(Node root) {
        if (root == null) return 0;
        
        int l = depth(root.left);   // Depth of left subtree
        int r = depth(root.right);  // Depth of right subtree
        
        // Update the maximum diameter found so far
        fans = Math.max(fans, l + r);
        
        // Return the height of the current subtree
        return 1 + Math.max(l, r);
    }

    // Method to calculate the diameter of the binary tree
    int diameter(Node root) {
        depth(root);
        return fans;  // Diameter in terms of edges
    }

    public static void main(String args[]) {
        DiameterofBinaryTreeDay82 tree = new DiameterofBinaryTreeDay82();

        // Creating a sample binary tree:
        //         1
        //        / \
        //       2   3
        //      / \
        //     4   5

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Calculating and printing the diameter of the tree
        int treeDiameter = tree.diameter(root);
        System.out.println("Diameter of the binary tree is: " + treeDiameter);
    }
}
