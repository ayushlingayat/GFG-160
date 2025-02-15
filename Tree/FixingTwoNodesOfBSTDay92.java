class Solution{
    
    void inorder(Node root,ArrayList<Node> arr){
        if(root==null){
            return ;
        }
        inorder(root.left,arr);
        arr.add(root);
        inorder(root.right,arr);
    }
    
    public Node correctBST(Node root){
        ArrayList<Node> arr=new ArrayList<>();
        inorder(root,arr);
        Node a=null;
        Node b=null;
        int j=0;
        
        for(int i=0;i<arr.size()-1;i++){
            if(arr.get(i).data>arr.get(i+1).data){
                if(a==null){
                    a=arr.get(i);
                    j=i;
                    break;
                }
            }
        }
        
        b=arr.get(j+1);
        for(int i=j+2;i<arr.size();i++){
            if(b.data>arr.get(i).data){
                b=arr.get(i);
            }
        }
        
        int temp=a.data;
        a.data=b.data;
        b.data=temp;
        
        return root;
    }
}
