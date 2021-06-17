class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int m = s.length() , n = wordDict.size();
        boolean[] dp = new boolean[m+1]; 
        
        dp[0] = true;
        
        for(int i = 0 ; i  <= s.length() ; i++){
            
            for(int j =0 ; j < wordDict.size() ; j++){
                String dict = wordDict.get(j);
                int l = dict.length();
                
                if(l> i)
                    continue;
                
                
               // System.out.println(s.substring(i-l , i)); 
                
                if(dp[i -l] && s.substring(i- l, i).equals(dict)){
                    
                    // System.out.println( i);
                    dp[i] =true;
                }
                
            }
            
        }
        
        // for(boolean b : dp)
            // System.out.print(b + " ");
  
        return dp[m];
        
    }
}