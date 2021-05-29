class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        
        int[] dp = new int[target+1];
        
        dp[0] = 1; //to make 0 empty array
        
        for(int i = 1 ; i<= target ;i++){
            for(int j =0 ; j < nums.length ; j++){
        
                if(nums[j] <= i){
                    
                    dp[i] += dp[i - nums[j]];
                    
                    
                }
                
                
            }
            
        }
        
        return dp[target];
        
        
    }
}