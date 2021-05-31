class Solution {
    public int maxCoins(int[] nums) {
     
        
        int[] newNums = new int[nums.length + 2];
        
        int index = 1;
        for(int x : nums){
            if(x > 0) // Omitting zeros
            newNums[index++] = x;
        }
        newNums[0] = newNums[index] = 1;
        int n = ++index;
        
        // for(int j =0 ; j < n ;j++){
        //         System.out.print(newNums[j]  + "  " );
        //     }
        //     System.out.println("");
        
        
        int[][] dp = new int[n][n];
        
        int max = 0;
        
        for(int d = 1; d < n-1 ; d++){
            
            for(int i = 1 ; i < n-d ; i++){
                
                int j = i + d;
                
                max =0 ;
                for(int k = i ; k <= j-1; k++){
                    // System.out.println(i + " " + k + " " +j);
                    max = Math.max(max , dp[i][k] + dp[k+1][j] + newNums[i-1] * newNums[k] * newNums[j]);
                   
                }
                
                dp[i][j] = max;
                
                
            }
            
            
        }
        
        // for(int i =0 ; i <n ; i++){
        //     for(int j =0 ; j < n ;j++){
        //         System.out.print(dp[i][j]  + "  " );
        //     }
        //     System.out.println("");
        // }
        
        return max;

        
    }
}