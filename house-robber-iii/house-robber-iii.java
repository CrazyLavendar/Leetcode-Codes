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
    public int rob(TreeNode root) {
        

        return helper(root , new HashMap<>());
    }
    
    public int helper(TreeNode root , HashMap<TreeNode , Integer> map){
        
        if(root == null)
            return 0;
        
        if(map.containsKey(root))
            return map.get(root);
        
        int val = root.val;
        if(root.left != null){
            val += helper(root.left.left , map) + helper(root.left.right , map);
        }
        
        if(root.right != null){
            val += helper(root.right.left , map) + helper(root.right.right , map);
        }
        
        
        map.put(root , Math.max(val , helper(root.left , map) + helper(root.right , map)));
        
        return map.get(root);
        
    }
    
}