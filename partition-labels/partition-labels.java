class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int[] lastAlp = new int[26];
        List<Integer> res = new ArrayList<>();
        for(int i =0; i<s.length() ; i++){
            int val = s.charAt(i) - 'a';
            lastAlp[val] = i;
        }
        
        int currLast = 0 , prevLast = -1;
        for(int i =0; i<s.length() ; i++){
            
            int val = s.charAt(i) - 'a';
           

            currLast = Math.max(currLast , lastAlp[val]);
            
            
            if(currLast > i) {
                continue;
            }
            else{
                res.add(currLast - prevLast);
                prevLast = currLast;
            }
    
        }
        return res;
    }
}