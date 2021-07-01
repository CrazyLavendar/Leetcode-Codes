class TrieNode{

    char val;
    boolean end;
    TrieNode node;
    TrieNode[] children = new TrieNode[27];
    public TrieNode(){}
    public TrieNode(char c){
        this.val = c;
    }

}

class WordDictionary {

    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(' ');
    }
    
    public void addWord(String word) {
        TrieNode w = root;
        for(char c : word.toCharArray()){
            if(w.children[c-'a'] == null){
                w.children[c-'a'] = new TrieNode(c);
            }
            w = w.children[c-'a'];
        }
        w.end = true;
    }
    public boolean search(String word) {
        
        return helper(root , word , 0);
    }
    
    
    public boolean helper(TrieNode w  , String word , int i){
    
    // System.out.println(i);
    
   
    if(i == word.length()){
        return w.end;
    }
    char c = word.charAt(i);
    if(c!= '.' && w.children[c -'a'] == null)
        return false;
     
    boolean res = false;

    if(c == '.'){

        for(int j =0; j < 26 ; j++){
            if(w.children[j] != null)
                res = res || helper(w.children[j] , word , i+1);
        }
        return res;

      }
        else{
           return helper(w.children[c-'a'] , word , i+1);
      }
    
         
  }

}



/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */