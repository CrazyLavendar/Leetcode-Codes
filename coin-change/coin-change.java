class Solution {
    public int coinChange(int[] coins, int amount) {
        
        /*
        int[] dp = new int[amount +1];
        
        Arrays.fill(dp , 10001);
        
        dp[0] =0;
        for(int i = 1 ; i< amount +1 ; i++){
            
            for(int j =0 ; j<coins.length; j++){
                
                 if(i >= coins[j])
                    dp[i] = Math.min(dp[i] , dp[i-coins[j]] + 1);
                
            }
            
        }
        
        return dp[amount] ==  10001 ? -1 : dp[amount];
        */

        int[] dp = new int[amount+1];
        Arrays.fill(dp , Integer.MAX_VALUE - 1);
        dp[0] = 0;
        
        
        for(int i = 1 ; i<= amount ; i++){
            for(int j = 0; j<coins.length ; j++)
                
                if( i >= coins[j]){
                   dp[i] = Math.min(dp[i-coins[j]] + 1, dp[i]); 
                }
            }
        
//         for(int x : dp)
//             System.out.print(x + " ");
        
        return dp[amount] == Integer.MAX_VALUE - 1? -1 : dp[amount] ;
        
    }
    
    
}