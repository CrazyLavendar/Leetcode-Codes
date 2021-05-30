class Solution {
    public int lastStoneWeightII(int[] stones) {
        
    int capacity =0 , odd = 0;
    for(int stone : stones)
        capacity += stone;
    
        // System.out.println(capacity);
        
    if(capacity %2 ==1) odd =1; 
    capacity = capacity / 2;
    
    int[][] dp = new int[stones.length +1][capacity +1];
        
    for(int i =0 ; i<= stones.length ; i++){
        
        for(int j =0; j<=capacity ; j++){
            
            if(i == 0 || j== 0)
                dp[i][j] = 0;
            else if( j < stones[i-1])
                dp[i][j] = dp[i-1][j];
            else
                dp[i][j] = Math.max(dp[i-1][j] , stones[i-1] + dp[i-1][j-stones[i-1]]);
            
        }
        
    }
        
        
//           for(int i =0 ; i<= stones.length ; i++){
        
//         for(int j =0; j<=capacity ; j++){
            
//            System.out.print(dp[i][j]);
            
//         }
//         System.out.println("");
//     }
        
        
        return (capacity - dp[stones.length][capacity])*2 + odd;
        
    }
}