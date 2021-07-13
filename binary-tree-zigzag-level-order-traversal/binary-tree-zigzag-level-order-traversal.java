/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
     
         List<List<Integer>> res = new ArrayList<>();
        helper(root , res ,0);
        
        for(int i = 1; i<res.size() ; i++)
            if(i%2 == 1)
                reverse(res.get(i));
        
        return res;
    }
    
    public void helper(TreeNode root ,  List<List<Integer>> res , int pos){
        
        if(root == null) return;
        
        if(pos == res.size())
            res.add(new ArrayList<>());
        res.get(pos).add(root.val);
        
        helper(root.left , res , pos+1);
        helper(root.right , res , pos+1);
        
    }
    
    public void reverse(List<Integer> list){
        int left = 0 , right = list.size() - 1;
        
        while(left < right){
            int temp = list.get(left);
            list.set(left++ , list.get(right));
            list.set(right-- , temp);
            
        }
    }
    
//     public int height(TreeNode root){
//         if(root == null)
//             return 0;
//         return Math.max(height(root.left) ,height(root.right)) + 1;
//     }
    
    
}