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
    int maxHeight = -1;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        helper(root , res , 0);
        return res;
    }
        public void helper(TreeNode root, List<List<Integer>> res , int h){
        if(root == null)
            return;
        if(h > maxHeight){
            res.add(new ArrayList<Integer>());
            maxHeight++;
        }
        if(h%2 == 0)
            res.get(h).add(root.val);
        else
            res.get(h).add(0,root.val);
        helper(root.left ,res , h+1);
        helper(root.right, res, h+1);
    }
}