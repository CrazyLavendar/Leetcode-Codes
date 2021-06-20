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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>>  res = new ArrayList<>();
        
        helper(root , res, new ArrayList<>() , targetSum);
        return res;
    }
    
    public void helper(TreeNode root , List<List<Integer>>  res, List<Integer> curr ,int targetSum){
        if(root == null)
            return;
        
        targetSum -= root.val;
        List<Integer> copyCurr = new ArrayList<>(curr);
        copyCurr.add(root.val);
        
        // leaf 
        if(root.left == null && root.right == null && targetSum == 0){
            res.add(copyCurr);
        }
        
        helper(root.left , res , copyCurr , targetSum);
        helper(root.right , res , copyCurr , targetSum);
        
    }
}