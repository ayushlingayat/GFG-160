import java.util.ArrayList;
import java.util.Stack;

public class TreeBoundaryTraversalDay86 {

    // Node class representing each node of the binary tree
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    // Method to perform boundary traversal of the binary tree
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (node == null) return ans;

        if (!leaf(node)) {
            ans.add(node.data);  // Add root if it's not a leaf
        }

        left(node, ans);       // Add left boundary
        addLeaves(node, ans);  // Add all leaf nodes
        right(node, ans);      // Add right boundary in reverse

        return ans;
    }

    // Check if a node is a leaf node
    public static boolean leaf(Node node) {
        return (node.left == null && node.right == null);
    }

    // Add left boundary (excluding leaves)
    void left(Node root, ArrayList<Integer> ans) {
        Node curr = root.left;

        while (curr != null) {
            if (!leaf(curr)) {
                ans.add(curr.data);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    // Add right boundary (excluding leaves) in reverse order
    void right(Node root, ArrayList<Integer> ans) {
        Node curr = root.right;
        Stack<Integer> st = new Stack<>();

        while (curr != null) {
            if (!leaf(curr)) {
                st.push(curr.data);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
    }

    // Add all leaf nodes
    void addLeaves(Node root, ArrayList<Integer> ans) {
        if (root == null) return;

        if (leaf(root)) {
            ans.add(root.data);
        } else {
            addLeaves(root.left, ans);
            addLeaves(root.right, ans);
        }
    }

    public static void main(String[] args) {
        TreeBoundaryTraversalDay86 tree = new TreeBoundaryTraversalDay86();

        // Creating a sample binary tree:
        //         1
        //        / \
        //       2   3
        //      / \   \
        //     4   5   6
        //        / \   \
        //       7   8   9

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);
        root.right.right = new Node(6);
        root.right.right.right = new Node(9);

        // Performing boundary traversal
        ArrayList<Integer> result = tree.boundaryTraversal(root);

        // Printing the boundary traversal result
        System.out.println("Boundary traversal of the binary tree:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
