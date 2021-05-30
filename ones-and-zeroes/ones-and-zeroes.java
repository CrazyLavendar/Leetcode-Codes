class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        
        int l = strs.length;
        int[][][] dp = new int[l+1][m+1][n+1];
        
        for(int i=0 ; i<= l ; i++){
            
            int zeros = 0 , ones = 0;
            if(i>0){
            zeros = getZeros(strs[i-1]) ; ones = strs[i-1].length() - zeros;
            }
          
            for(int j=0; j<= m; j++){
                for(int k=0 ; k<= n ; k++){
                    
                    if(i==0)
                        dp[i][j][k] =0;
                    else if(j >= zeros && k>= ones)
                      dp[i][j][k] =  Math.max(dp[i-1][j][k] ,(1 + dp[i-1][j-zeros][k-ones]));
                    else
                          dp[i][j][k] = dp[i-1][j][k];
                    
                                      // System.out.println(zeros + " " + ones + "----");

                    // System.out.println(dp[i][j][k]);
                    
                }
            }
        }
        return dp[l][m][n];
    }
    
    public int getZeros(String s){
        
       
        int res =0; 
        for(int i =0 ; i< s.length() ; i++){
            if(s.charAt(i) == '0')
                res++;
        }
         // System.out.println(s + " res : " + res);
        return res;
    }
}