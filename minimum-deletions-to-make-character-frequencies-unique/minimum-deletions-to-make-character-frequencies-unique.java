class Solution {
    public int minDeletions(String s) {
        
        int[] alp = new int[26];
        
        for(char c : s.toCharArray()){
            alp[c-'a']++;
        }
        
        // for(int i : alp){
        //     System.out.print(i + " ");
        // }
        
        Set<Integer> set = new HashSet<>();
        
        int res =0;
        for(int x : alp){
            
            if(x == 0)
                continue;
            if(!set.contains(x)){
                 // System.out.println(x + " " );
                set.add(x);
            }else{
                
                int near = nearest(x , set);
                
                // System.out.println(x + " " +near);
                
                if(near!=0)
                 set.add(near);
                res += Math.abs(x - near);
                
            }
            
            
        }
        
        
        
        return res;
    }
    
    public int nearest(int x , Set<Integer> set) {
        
        int left = Integer.MAX_VALUE  , right =  Integer.MAX_VALUE  ;
        int i = x-1;
        while(i >= 0){
             if(set.contains(i)){
                 i--;
             }else{
                 left = i;
                 break;
             }
                 
        }
        
        i = x+1;
        while(true){
             if(set.contains(i)){
                 i++;
             }else{
                 right = i;
                 break;
             }
                 
        }
        return Math.min(left, right);
    }
    
}