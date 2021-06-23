class Solution {
    public boolean canPartition(int[] nums) {
        
          int sum = 0;
        for(int x : nums)
            sum += x;
        
        if(sum % 2 == 1)
            return false;
        
        int target = sum / 2;
        
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        
        int currSum = 0;
        dp[0][0] = true;
        for(int i = 1 ; i<= nums.length ; i++){
            currSum += nums[i-1];
            
            for(int j =0 ;j<= currSum && j <= target ; j++ ){
                if(j==0){
                    dp[i][j] = true;
                }
                else if(j < nums[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
            }
            
            
        }
        
        // for(boolean b : dp)
            // System.out.print(b + " ");
            
        
        return dp[nums.length][target];
    }
}