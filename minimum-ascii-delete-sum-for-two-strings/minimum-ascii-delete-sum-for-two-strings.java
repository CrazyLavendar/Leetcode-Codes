class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        
    String common = lcs(s1.toCharArray() , s2.toCharArray());
        System.out.println(common);
     return ascii(s1) + ascii(s2) - 2 * ascii(common);
    }
    
    public int ascii(String s){
        int res =0 ;
        char[] ch = s.toCharArray();
        for(char x : ch)
            res += (int)x;
        return res;
        
    }
    
    public String lcs(char[] a , char[] b){
        
        int m = a.length , n = b.length;
        String[][] dp = new String[m+1][n+1];
        for(int i =0 ; i<= m ; i++){
            for(int j=0 ; j<=n ; j++){
                if(i==0 || j==0)
                    dp[i][j] = "";
                else if(a[i-1] == b[j-1]){
                    dp[i][j] = dp[i-1][j-1] + a[i-1];
                }
                else{
                    if(dp[i-1][j].length() > dp[i][j-1].length())
                        dp[i][j]  = dp[i-1][j];
                    else if(dp[i-1][j].length() < dp[i][j-1].length())
                        dp[i][j] = dp[i][j-1];
                    else{
                        if(ascii(dp[i-1][j]) > ascii(dp[i][j-1]))
                            dp[i][j]  = dp[i-1][j];
                        else
                            dp[i][j]  = dp[i][j-1];
                    }
                }
            }
        }
        return dp[m][n];

    }
}