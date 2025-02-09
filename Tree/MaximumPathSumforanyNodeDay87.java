public class MaximumPathSumforanyNodeDay87 {
    int maxSum = Integer.MIN_VALUE;

    // Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node node) {
        if (node == null)
            return 0;

        traverse(node);
        return maxSum;
    }

    // Helper function to traverse the tree and calculate the maximum path sum
    public int traverse(Node node) {
        if (node == null)
            return 0;

        // Recursively get the maximum path sum from left and right subtrees
        int leftSum = Math.max(0, traverse(node.left));  // Ignore negative sums
        int rightSum = Math.max(0, traverse(node.right)); // Ignore negative sums

        // Calculate the maximum path sum with the current node as the highest node
        int currentMax = node.data + leftSum + rightSum;

        // Update the global maximum sum if the current path sum is greater
        maxSum = Math.max(maxSum, currentMax);

        // Return the maximum sum path "including" the current node and one of its subtrees
        return node.data + Math.max(leftSum, rightSum);
    }

    // Node class representing each node in the binary tree
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String args[]) {
        MaximumPathSumforanyNodeDay87 tree = new MaximumPathSumforanyNodeDay87();

        // Creating a sample binary tree:
        //        10
        //       /  \
        //     2    10
        //    / \     \
        //   20  1    -25
        //             / \
        //            3   4

        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);

        int result = tree.findMaxSum(root);
        System.out.println("Maximum Path Sum: " + result);
    }
}
