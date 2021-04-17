class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int l = cost.length;
        int[] dp = new int[l];
        dp[0] = cost[0] ;
        dp[1] = cost[1];
        for(int i=2; i<l; i++)
            dp[i] = Math.min(dp[i-1] , dp[i-2]) +cost[i];
        
        return Math.min(dp[l-1] , dp[l-2]);
        
    }
    

        
        
    }
