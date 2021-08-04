class Solution {
    public int maxSubArray(int[] nums) {
        
        int max = Integer.MIN_VALUE, curr =0;
        for(int x : nums){
            curr += x;
            max = Math.max(max, curr);
            if(curr < 0) curr = 0;
        }
        // max = Math.max(max, curr);
        return max;
    }
}