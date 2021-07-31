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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null)
            return new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>>  res = new ArrayList<>();
        List<TreeNode> curr = new ArrayList<>();
        curr.add(root);
        List<TreeNode> temp = new ArrayList<>();
        while(!curr.isEmpty()){
            res.add(new ArrayList<>());
            for(TreeNode node : curr){
                res.get(res.size() -1).add(node.val);
                if(node.left != null){
                    temp.add(node.left);
                }
                if(node.right != null){
                    temp.add(node.right);
                }
            }
            
            curr = new ArrayList<>(temp);
            temp.clear();
        }
        
        return res;
    }
}