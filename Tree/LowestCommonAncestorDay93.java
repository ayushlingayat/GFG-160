class Solution {
    Node LCA(Node root, Node n1, Node n2) {
        // your code here.
        return (root.data>n1.data && root.data>n2.data)?LCA(root.left,n1,n2):(root.data<n1.data && root.data<n2.data)?LCA(root.right,n1,n2):root;
    }
}
