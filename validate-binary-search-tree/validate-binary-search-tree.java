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
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true; 
        return leftCheck(root.left , root.val) & rightCheck(root.right , root.val) & isValidBST(root.left) & isValidBST(root.right);
    }
    
    public boolean leftCheck(TreeNode root  , int val){
        if(root == null)
            return true;
        return root.val < val & leftCheck(root.left , val) & leftCheck(root.right , val);
    }
        
    public boolean rightCheck(TreeNode root  , int val){
        if(root == null)
            return true;
        return root.val > val & rightCheck(root.left , val) & rightCheck(root.right , val);
    }
    
    
}