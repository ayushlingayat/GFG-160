import java.util.ArrayList;

public class InorderTraversalDay85 {

    // Node class representing each node of the binary tree
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    // Method to perform in-order traversal and return the result as an ArrayList
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        helper(root, arr);
        return arr;
    }

    // Helper method for recursive in-order traversal
    void helper(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        helper(root.left, arr);  // Traverse left subtree
        arr.add(root.data);      // Visit root node
        helper(root.right, arr); // Traverse right subtree
    }

    public static void main(String args[]) {
        InorderTraversalDay85 tree = new InorderTraversalDay85();

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

        // Performing in-order traversal
        ArrayList<Integer> result = tree.inOrder(root);

        // Printing the in-order traversal result
        System.out.println("In-order traversal of the binary tree:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
