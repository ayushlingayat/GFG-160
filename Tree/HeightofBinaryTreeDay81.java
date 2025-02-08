class HeightofBinaryTreeDay81 {

    // Node class representing each node of the binary tree
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    // Method to calculate the height of the binary tree
    int height(Node node) {
        if (node == null) return -1;  // For height in terms of edges, use -1; for nodes, use 0.
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public static void main(String args[]) {
        HeightofBinaryTreeDay81 tree = new HeightofBinaryTreeDay81();

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

        // Calculating the height of the tree
        int treeHeight = tree.height(root);
        System.out.println("Height of the binary tree is: " + treeHeight);
    }
}
