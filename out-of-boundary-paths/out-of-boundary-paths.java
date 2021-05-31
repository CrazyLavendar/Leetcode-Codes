class Solution {
    int m , n;
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    int mod = 1000000000 + 7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        
        int[][][] dp = new int[m][n][maxMove +1];
        
        for(int i = 0 ; i< m ;i++)
            for(int j =0 ; j< n ; j++)
                for(int k =0 ; k<= maxMove ;k++)
                    dp[i][j][k] = -1;
        
        
        return helper(startRow , startColumn , maxMove , dp);
        
    }
    
    public int helper(int row , int col , int maxMove , int[][][] dp){
        // System.out.println("HII");
        if(row < 0 || col < 0 || row >= m || col >=n){
            return 1;
        }
        if(maxMove ==0) return 0;
        if(dp[row][col][maxMove] != -1) return dp[row][col][maxMove];
        
        dp[row][col][maxMove] = 0;
        
        for(int[] dir : dirs){
            int x = row +dir[0];
            int y = col +dir[1];
            
            
            dp[row][col][maxMove] = (dp[row][col][maxMove] +  helper(x , y , maxMove -1 , dp) ) % mod ;
            
            
        }
        
        
        return dp[row][col][maxMove];
        
    }
}