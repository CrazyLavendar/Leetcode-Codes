class Solution {
    public int minDistance(String word1, String word2) {
        
        int m = word1.length() , n = word2.length();
        
        if(m==0 && n==0)
            return 0;
        if(m==0 && n!=0)
            return n;
        if(m!=0 && n==0)
            return m;
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i =0; i <= m ; i++){
            dp[i][0] = i;
        }
        
        for(int i =1; i <= n ; i++){
            dp[0][i] = i;
        }
        
        for(int i =1 ; i<= m ;i++){
            for(int j =1; j <= n ; j++){
               
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else{
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
                }
                
            }
        }
        
        
        
        
//         for(int i =0 ; i< m ; i++){
            
//             for(int j =0 ; j< n; j++){
//                 System.out.print(dp[i][j] + " ");
//             }
//             System.out.println("");
//         }
        
      return dp[m][n];
        
        
//             int[][] dp = new int[word2.length()+1][word1.length()+1];
//     for(int i = 0; i <= word2.length(); i++) {
//         for(int j = 0; j <= word1.length(); j++) {
//             if(i == 0 && j == 0) dp[i][j] = 0; // no strings given
//             else if(i == 0 && j != 0) {
//                 dp[i][j] = j; // word2 is empty
//             } else if(i != 0 && j == 0) {
//                 dp[i][j] = i; // word1 is empty
//             } else if(word2.charAt(i-1) != word1.charAt(j-1)) {
//                 dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
//             }else {
//                 dp[i][j] = dp[i-1][j-1]; // same characters just carry over previous chars from both
//             }
//         }
//     }
//     return dp[word2.length()][word1.length()];
        
      
    }
}