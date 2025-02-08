public class ConstructTreeInorderPreorderDay84 {

    // Node class representing each node of the binary tree
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    static int idx = 0;

    // Helper method to build the tree recursively
    public static Node build(int s1, int e1, int in[], int pre[]) {
        if (s1 > e1 || idx >= pre.length) return null;

        // Create a new node with the current preorder element
        Node newNode = new Node(pre[idx]);
        idx++;

        // If this node has no children (leaf node)
        if (s1 == e1) return newNode;

        // Find the index of the current node in the inorder array
        int mid = s1;
        for (int i = s1; i <= e1; i++) {
            if (in[i] == newNode.data) {
                mid = i;
                break;
            }
        }

        // Recursively build the left and right subtrees
        newNode.left = build(s1, mid - 1, in, pre);
        newNode.right = build(mid + 1, e1, in, pre);

        return newNode;
    }

    // Method to initiate tree construction
    public static Node buildTree(int inorder[], int preorder[], int n) {
        idx = 0;
        return build(0, n - 1, inorder, preorder);
    }

    // Method for in-order traversal to verify the constructed tree
    public static void inOrderTraversal(Node root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public static void main(String args[]) {
        int inorder[] = {4, 2, 5, 1, 3, 6};
        int preorder[] = {1, 2, 4, 5, 3, 6};
        int n = inorder.length;

        // Building the tree
        Node root = buildTree(inorder, preorder, n);

        // Printing the in-order traversal of the constructed tree
        System.out.println("In-order traversal of the constructed tree:");
        inOrderTraversal(root);
    }
}
