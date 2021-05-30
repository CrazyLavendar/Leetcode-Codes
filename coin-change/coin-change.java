class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount +1];
        
        Arrays.fill(dp , 10001);
        
        
        for(int i = 0 ; i< amount +1 ; i++){
            
            for(int j =0 ; j<coins.length; j++){
                
                if(i==0)
                    dp[i] =0; // if amount is zero no coins required
                else if(i >= coins[j])
                    dp[i] = Math.min(dp[i] , dp[i-coins[j]] + 1);
                
            }
            
        }
        
        return dp[amount] ==  10001 ? -1 : dp[amount];
    }
}