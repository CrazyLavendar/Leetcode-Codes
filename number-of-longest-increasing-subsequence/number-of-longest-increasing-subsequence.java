class Solution {
    public int findNumberOfLIS(int[] nums) {
        
 //         // return lengthofLIS(nums, Integer.MIN_VALUE, 0);
        
        int len = nums.length;
        int[] dp = new int[len] , cnt = new int[len];
        int max = 0 , res =0;
        for(int i = 0 ;i< len ; i++){
            
            dp[i] = 1; cnt[i] = 1;
            for(int j = 0 ; j<i ; j++){
                
                if(nums[j] < nums[i]){
                    
                    if(dp[i] == dp[j] + 1) cnt[i] += cnt[j];
                    
                    if(dp[i] < dp[j] + 1){
                         dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                     }
                }
                
            }
            
            if(max == dp[i])
                res += cnt[i];
            else if( max < dp[i]){
                max = dp[i];
                res =cnt[i];
            }
            
            
            
        }
        
        return res;
        
    }
}