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
    int res = Integer.MIN_VALUE ;
    public int maxPathSum(TreeNode root) {
     
        traversal(root);
        return res;
    }
    
    public int traversal( TreeNode root){
        if(root ==null)
            return 0;
        
        
        
        int left = traversal(root.left);
        int right = traversal(root.right);
        int curr = root.val;
        if(left < 0)
            left  =0 ;
        if(right < 0)
            right = 0;
        
        res = Math.max(res , curr + left + right);
        
        return root.val + Math.max(left , right); 
        }
}