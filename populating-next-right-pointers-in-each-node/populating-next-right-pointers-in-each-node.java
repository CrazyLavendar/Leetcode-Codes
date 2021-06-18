/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    Node a , b;
    public Node connect(Node root) {

        
        // System.out.println(height(root));
        
        int h  = height(root);
        
        
        for(int i = 1; i<=h ; i++){
             a = null ; b = null;
             level(root, i);
        }
           
        return root;
        
    }
    
    public void level(Node root , int l){
        
        if(l == 1){
            a = b;
            b = root;
            // System.out.println(l + " "+ root.val);
            if(a != null){
                a.next = b;
            }
        }
        else{
            
            level(root.left , l-1 );
            level(root.right , l-1 );
        
        }
        
        
    }
    
    public int height(Node root){
        
        if(root == null){
            return 0;
        }
        
        return 1 + height(root.left);
            
        
        
    }
    
   
}