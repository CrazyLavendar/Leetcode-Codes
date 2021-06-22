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
    int res =0 ;
    public int pathSum(TreeNode root, int targetSum) {
     
        Map<Integer , Integer> map = new HashMap<>();
        map.put(0,1);
        path(root ,map,0 , targetSum );
        return res;
    }
    
    public void path(TreeNode root , Map<Integer , Integer> map, int sum , int k){
        if(root == null)
            return;
        
        sum += root.val;
        if(map.containsKey(sum - k)){
                res += map.get(sum - k);
        }
        map.put(sum , map.getOrDefault(sum , 0) + 1);
        // System.out.println(res);
        path(root.left , map , sum , k);
        path(root.right , map , sum , k);
                
        map.put(sum , map.get(sum) - 1);
        sum -= root.val;
        
    }
    
 
}