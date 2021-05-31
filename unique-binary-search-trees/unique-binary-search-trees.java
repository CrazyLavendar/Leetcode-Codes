class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        
        dp[0] = dp[1] = 1;
        
        for(int i = 2; i<= n ;i++){
            
            for(int j = 0 ; j<i ; j++){
                
                dp[i] += dp[j] * dp[i-j-1];
                
            }
            
        }
        
        
//         for(int x : dp)
//             System.out.print( x + " ");
        
        return dp[n];
        
    }
    
//     public int helper(int index , int[] dp){
        
//         // if(index == 0 || index ==1)
//         //     return 1;
        
//         if(dp[index] !=0)
//             return dp[index];
        

//         for(int i = 2 ; i<= index ; i++){
            
//             dp[i] += helper(i-1 , dp) * helper(index - i,dp);
//         }
        
//         return dp[index];
        
//     }
}