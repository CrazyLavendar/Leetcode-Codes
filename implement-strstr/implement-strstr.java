class Solution {
    public int strStr(String h, String n) {
        
        if(h.equals(n))
            return 0;
        
        // System.out.println(str(h,1,n));
        
        for(int i =0 ; i< h.length(); i++){

            if(str(h , i , n))
                return i;
            
        }
        
        
        return -1;
    }
    
    public boolean str(String s , int i , String p){
        
        if(i+p.length() > s.length())
            return false;
        
        int j = 0;
        while(j < p.length()){
            if(s.charAt(i++) != p.charAt(j++))
                return false;
        }
        
        return true;
        
    }
    
    
}