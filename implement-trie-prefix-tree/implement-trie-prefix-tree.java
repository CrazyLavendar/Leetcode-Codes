class TrieNode {   
    public char val;
    public boolean end; 
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
    TrieNode(char c){
        TrieNode node = new TrieNode();
        node.val = c;
    }
}


class Trie {

    /** Initialize your data structure here. */
    TrieNode root;
    
    public Trie() {
        root = new TrieNode(' ');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TrieNode w = root;
        for(char c : word.toCharArray()){
            if(w.children[c-'a'] == null){
                w.children[c-'a'] = new TrieNode(c);
            }
            w = w.children[c-'a'];
        }
        w.end = true;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        int i = 0 , l = word.length();
        TrieNode w = root;
        for(char c : word.toCharArray()){
            if(w.children[c-'a'] == null){
                return false;
            }
            w = w.children[c-'a'];
        }
        return w.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        int i = 0 , l = word.length();
        TrieNode w = root;
        for(char c : word.toCharArray()){
            if(w.children[c-'a'] == null){
                return false;
            }
            w = w.children[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */