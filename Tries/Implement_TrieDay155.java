class Node{
    public Node[] children = new Node[26];
    public boolean end;
    public Node(){
        for(int i=0;i<children.length;i++){
            this.children[i] = null;
        }
        this.end = false;
    }
}

class Trie {
    private Node root =  new Node();

    public void insert(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            if(i == word.length()-1){
                if(curr.children[word.charAt(i)-'a']!=null){
                    curr = curr.children[word.charAt(i)-'a'];
                }
                else{
                    Node node = new Node();
                    curr.children[word.charAt(i)-'a'] = node;
                    curr = node;
                }
                curr.end = true;
            }
            else{
                if(curr.children[word.charAt(i)-'a']!=null){
                    curr = curr.children[word.charAt(i)-'a'];
                }
                else{
                    Node node = new Node();
                    curr.children[word.charAt(i)-'a'] = node;
                    curr = node;
                }
            }
        }
    }

    public boolean search(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            if(curr.children[word.charAt(i)-'a'] == null){
                return false;
            }
            curr = curr.children[word.charAt(i)-'a'];
        }
        return curr.end;
    }

    public boolean isPrefix(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            if(curr.children[word.charAt(i)-'a'] == null){
                return false;
            }
            curr = curr.children[word.charAt(i)-'a'];
        }
        return true;
    }
}