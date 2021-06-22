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
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        helper(root , root.val);
        return max;
    }
    
    public int helper(TreeNode root , int val){
        if(root == null)
            return 0;
        
        int left = helper(root.left , root.val);
        
        
        int right = helper(root.right, root.val);
        max = Math.max(left + right , max);
        
        if(root.val == val){
            return Math.max(left , right) + 1;
        }
            
        return 0;
        
        
    }
}