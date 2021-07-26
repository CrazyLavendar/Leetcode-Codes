class Solution {
    public int strStr(String h, String n) {
        
        
        int[] pattern = kmpPreProcess(n);
        
//         for(int x : pre)
//         System.out.print( x +  " ");
        
//         return h.indexOf(n);
        int i =0, j =0;
        while(i<h.length() && j < n.length()){
            if(h.charAt(i) == n.charAt(j)){
                i++;j++;
                
            } else if(j>0){
                j = pattern[j-1];
            }else{
                i++;
            }
        }
        
    return j  == n.length()? i-j : -1;        

    }
    
public int[] kmpPreProcess(String n){
    
    int[] pattern = new int[n.length()];
    
    int i =1 , j =0;
    while(i < n.length()){
        if(n.charAt(j) == n.charAt(i)){
            pattern[i] = j+1;
            j++;
        }else if(j > 0){
            j = pattern[j-1];
            continue;
            
        }else{
            pattern[i] = 0;
        }
        i++;
    }
    
    return pattern;
}
    
    
}