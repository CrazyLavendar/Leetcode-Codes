class Solution {
    

    
    public List<Integer> findAnagrams(String s, String p) {
        
        int m = s.length() , n = p.length();
        List<Integer> res = new ArrayList<>();
        if(n > m)
            return res;
        
        int[] pVal = new int[26];
        
        for(char c : p.toCharArray())
            pVal[c - 'a']++;
        
        int[] anag = new int[26];
        
        int i=0 ;
        for(; i < n-1 ; i++){
            anag[s.charAt(i) - 'a']++;
        }
        
   
        
        for(int j =0; i <m ;i++ , j++){
            anag[s.charAt(i) - 'a']++;
            
            if(Arrays.equals(pVal , anag))
                res.add(j);
            
            anag[s.charAt(j) - 'a']--;
        }
        
        // System.out.println(Arrays.equals(pVal , anag));
        
        
        

        return res;
    }
}