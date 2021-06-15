class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> res = new ArrayList<>();
        
        boolean[] vis = new boolean[strs.length];
        
        String[] sortedStrs  = strs.clone();
        
        for(int i =0 ; i<strs.length ; i++){
            
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            sortedStrs[i] = String.valueOf(temp);
        }
        
        for(int i =0 ; i<strs.length ; i++){
            
            if(!vis[i]){
                
                List<String> anagram = new ArrayList<>();
                anagram.add(strs[i]);
                
                for(int j = i + 1 ; j < strs.length ; j++){
                    
                    if(!vis[j] && strs[i].length() == strs[j].length() && sortedStrs[i].equals(sortedStrs[j]) ){
                        // System.out.println(sortedStrs[i] + " " + sortedStrs[j]);
                        vis[j] = true;
                        anagram.add(strs[j]);

                    }
                }
                
                res.add(anagram);
            }
            
        }
        
        
        return res;
    }
}