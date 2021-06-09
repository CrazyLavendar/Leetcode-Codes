class Solution {
    public int twoEggDrop(int n) {
        
        int eggs = 2;

        return dropEgg(n , eggs);
    }
    
    public int dropEgg(int floors , int eggs){
        
        int[][] dp = new int[eggs+1][floors+1];
        
        

        
        
        for(int i =1 ; i<= eggs ; i++){
            for(int j =1; j <= floors ; j++){
                
                if(i==1)
                    dp[i][j] = j;
                
                if(dp[i][j] > 0)
                    continue;
                
                if(j< i){
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                
                dp[i][j]= Integer.MAX_VALUE;
                for(int k = 1 ; k<=j ; k++){
                    
                dp[i][j] = Math.min( dp[i][j] , 1 + Math.max(dp[i-1][k-1] , dp[i][j-k]));
                }
                
                
            }
        }
        
        
        return dp[eggs][floors];
        
    }
}