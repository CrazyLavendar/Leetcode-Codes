class Solution {
    public long maxAlternatingSum(int[] nums) {
        
        int n = nums.length;
        
        long res1 = 0, res2 =0;
        for(int i =0 ; i<n ; i++){
            res1 = Math.max(res1 , res2 + nums[i]);
            res2 = res1 - nums[i];
        }
        
        return res1;
    }
}