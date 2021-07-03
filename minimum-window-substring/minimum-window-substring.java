class Solution {
    public String minWindow(String s, String t) {
        
        if(t.length() > s.length())
            return "";
        
        
        Queue<Integer> q = new LinkedList<>();
        
        int[] t_alp = new int[128];
        int[] s_alp = new int[128];
        
        for(int i =0; i<t.length() ; i++)
            t_alp[t.charAt(i) - '0']++;
        
        int i =0 ;
        for( ; i< s.length() ; i++){
            q.add(i);
            s_alp[s.charAt(i) - '0']++;
            if(contains(s_alp , t_alp))
                break;
        }
        
        if(i == s.length())
            return "";
        
        reduction(s, s_alp , t_alp , q);
        int start = q.peek() , end  = i;
        // System.out.println(q);
        
        for( i = i+1; i < s.length() ; i++){
            s_alp[s.charAt(q.poll()) - '0']--;
            q.add(i);
            s_alp[s.charAt(i) - '0']++;
            
            if(contains(s_alp , t_alp)){
                reduction(s, s_alp , t_alp , q);
                start = q.peek();
                end = i;
            }
           
            
        }
        
        // System.out.println(s + " " +start + " " + end);
        
        return  s.substring(start , end +1);
    }
    
    public void reduction(String s, int[] s_alp ,int[] t_alp , Queue<Integer> q){
        
        while(!q.isEmpty()){
            int charVal = s.charAt(q.peek()) - '0';
            if(s_alp[charVal] - 1 >= t_alp[charVal]){
                q.poll();
                s_alp[charVal]--;
            }else{
                break;
            }
        }
        
    }
    
    public boolean contains(int[] s_alp  ,int[] t_alp){
        for(int i =0 ; i < t_alp.length ; i++){
            if(t_alp[i] > s_alp[i])
                return false;
        }
        return true;

    }
    
    
}