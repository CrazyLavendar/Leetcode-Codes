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
    int k , res;
    
    public int kthSmallest(TreeNode root, int k) {
    this.k = k;
    bst(root);
    return res;
        
    }
    
    public  void bst(TreeNode root){
        if(root == null)
            return;
        kthSmallest(root.left , k);
        k--;
        if(k==0)
            res = root.val;
        kthSmallest(root.right , k);
    }
}