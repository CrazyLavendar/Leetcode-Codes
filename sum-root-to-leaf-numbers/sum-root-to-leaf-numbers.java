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
    int res = 0;
    public int sumNumbers(TreeNode root) {
        
        if(root == null){
            return 0;
        }
         sumNumbers(root , "");  
        return res; 
    }
    
    public String sumNumbers(TreeNode root , String curr) {
        
        if(root == null)
            return curr;
    if(root.left == null && root.right == null){
            res += Integer.parseInt(curr + root.val)  ;
            return null;
        }
        
        if(curr.equals("") && root.val == 0) {
            curr = "";
        }else
            curr += root.val;
        
        sumNumbers(root.left , curr );
        sumNumbers(root.right , curr );
        
        return curr;
    }
  
    
}