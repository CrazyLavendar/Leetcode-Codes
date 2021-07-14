class Solution {
    public int firstUniqChar(String s) {
        
        Integer[] abc = new Integer[26];
        
        for(int i =0 ; i < s.length() ; i++){
            
            int val = s.charAt(i) - 'a';
            
            if(abc[val] == null)
                abc[val] = i;
            else 
                abc[val] = -1;
        }
        
        for(int i =0 ; i < s.length() ; i++){
            
            int val = s.charAt(i) - 'a';
            
            if(abc[val] > -1)
                return i;

        }
        

        return -1;
    }
}