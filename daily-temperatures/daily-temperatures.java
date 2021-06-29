class Solution {
    public int[] dailyTemperatures(int[] t) {
        
        int n = t.length;
        int[] res = new int[n];
        
        for(int i =0 ; i < n-1 ; i++){
            
            int curr = t[i];
            
            int j = i+1;
            while(j < n && curr >= t[j])j++;
            
            if(j!=n)
            res[i] = j - i;
            
        }
        
        return res;
    }
    
}