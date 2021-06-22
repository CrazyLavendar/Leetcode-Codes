class Solution {
    public int numMatchingSubseq(String s, String[] words) {
    
        List<StringBuilder>[] list = new List[26];
        for(int i =0 ; i< 26 ; i++)
            list[i] = new ArrayList<>();
        
        for(String word : words){
            int val = word.charAt(0) - 'a';
            list[val].add(new StringBuilder(word));
        }
        
        int ans =0 ;
        for(char c : s.toCharArray()){
            
            int val = c - 'a';
            
            List<StringBuilder> temp = new ArrayList<>(list[val]);
            
            list[val].clear();
            
            for(StringBuilder str : temp){
                str.deleteCharAt(0);
                
                if(str.length() ==0){
                    ans++;
                }
                else{
                    int newVal = str.charAt(0) - 'a';
                    list[newVal].add(str);
                }
            }
        }

        return ans;
    }
}