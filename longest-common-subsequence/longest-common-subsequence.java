class Solution {
    public int longestCommonSubsequence(String a, String b) {
        int m = a.length(), n = b.length();
        if(m ==0|| n ==0)
            return 0;
        int[][] dp = new int[m+1][n+1];
        char[] aa = a.toCharArray() , bb = b.toCharArray();
        for(int i =0 ; i<= m ; i++){
            for(int j=0 ; j<=n ; j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else if(aa[i-1] == bb[j-1])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }


        return dp[m][n];
    }
}