class Solution {
    public int change(int amount, int[] coins) {
        
        int N = coins.length;
        int[][] dp = new int[N+1][amount+1];
        
        for(int i =0 ; i<= N; i++)
            dp[i][0] = 1; // for zero amount , 1 way is possible
        
        for(int i = 1 ; i<= N ; i++){
            for(int j =1 ; j<= amount ; j++){
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }
//                 int[][] dp = new int[coins.length+1][amount+1];
//         dp[0][0] = 1;
        
//         for (int i = 1; i <= coins.length; i++) {
//             dp[i][0] = 1;
//             for (int j = 1; j <= amount; j++) {
//                 dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
//             }
//         }
        //  for(int i = 0 ; i<= N ; i++){
        //     for(int j =0 ; j<= amount ; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //      System.out.println("");
        // }
        return dp[N][amount];
        
    }
}