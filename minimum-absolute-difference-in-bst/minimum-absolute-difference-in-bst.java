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
    
    int res = Integer.MAX_VALUE, prev = -1;
    boolean prevOccupy = false;
    public int getMinimumDifference(TreeNode root) {
        if(root ==null)
            return Integer.MAX_VALUE;
        
        getMinimumDifference(root.left);
        if(prevOccupy)
            res = Math.min(res , Math.abs(prev - root.val));
        prevOccupy = true;
        prev = root.val;
        getMinimumDifference(root.right);
        
        return res;
        
    }
}