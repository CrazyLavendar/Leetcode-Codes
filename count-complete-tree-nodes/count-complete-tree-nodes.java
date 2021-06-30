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
    public int countNodes(TreeNode root){
        
        return helper(root);

    }
    public int helper(TreeNode root){
        
        if(root == null)
            return 0;
        int left = heightLeft(root);
        int right = heightRight(root);
        // System.out.println(left + " " + right);
        if(left == right)
            return (int)Math.pow(2 , left)-1;
        else return 1 + helper(root.left) + helper(root.right);
    }
    
    private int heightLeft(TreeNode root){
        if(root == null)
            return 0;
        return 1 + heightLeft(root.left);
    }
    private int heightRight(TreeNode root){
        if(root == null)
            return 0;
        return 1 + heightRight(root.right);
    }
}