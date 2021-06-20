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
    
    
    public List<Integer> rightSideView(TreeNode root) {
    Map<Integer , Integer> map = new HashMap<>();
    traversal(root , map, 0);
        
    return new ArrayList<Integer>(map.values());
        
    }
    public void traversal(TreeNode root , Map<Integer , Integer> map , int depth){
        if(root == null)
            return;
        
        map.put(depth , root.val);
        traversal(root.left , map , depth + 1);
        traversal(root.right, map , depth + 1);
    }
    
}