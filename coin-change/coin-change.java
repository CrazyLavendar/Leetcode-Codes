class Solution {
    public int coinChange(int[] coins, int a) {
     
        int n = coins.length;
        int[] dp = new int[a+1];
        Arrays.fill(dp , 10001);
        dp[0] = 0;
        for(int x : coins){
            
            for(int i = 0 ; i<= a ; i++){
                
               if(x<= i){
                   
                    dp[i] = Math.min(dp[i] , dp[i-x] + 1);
                   // System.out.println(i + " " + x + " " + dp[i]);
                }
            }
        }
        
        // for(int x : dp){
        //     System.out.print(x + " ");
        // }
        
       
        return dp[a]==10001? -1 : dp[a];
    }
}