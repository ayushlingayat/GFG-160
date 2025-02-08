public class MirrorTreeDay83 {

    // Node class representing each node of the binary tree
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    // Method to mirror the binary tree
    void mirror(Node node) {
        if (node == null) {
            return;
        }

        // Recursively mirror left and right subtrees
        mirror(node.left);
        mirror(node.right);

        // Swap left and right children
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    // Method to perform in-order traversal of the binary tree
    void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    public static void main(String args[]) {
        MirrorTreeDay83 tree = new MirrorTreeDay83();

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

        System.out.println("In-order traversal before mirroring:");
        tree.inOrderTraversal(root);
        System.out.println();

        // Mirroring the binary tree
        tree.mirror(root);

        System.out.println("In-order traversal after mirroring:");
        tree.inOrderTraversal(root);
        System.out.println();
    }
}
