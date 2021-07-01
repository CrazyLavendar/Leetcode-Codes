class Node{
    int cVal ,count;
    public Node(int cVal , int count){
        this.cVal = cVal;
        this.count = count;
    }
}

class Solution {
    
    char[] alp = "abcdefghijklmnopqrstuvwxyz".toString().toCharArray();
    
    public String reorganizeString(String s) {
        
        double len = s.length();
        int[] abc = new int[26];
        for(char c  : s.toCharArray()){
            abc[c-'a']++;
            if(abc[c-'a'] >= (len/2) + 1)
                return "";
        }
        Queue<Node> q = new LinkedList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> a.count == b.count? a.cVal - b.cVal : b.count - a.count);
        
        for(int i =0; i < 26 ; i++){
            if(abc[i] == 0)
                continue;
            else{
                pq.add(new Node(i , abc[i]));
            }
        }
        int lastVal = -1;
        StringBuilder sb = new StringBuilder(""); 
        while(!pq.isEmpty() || !q.isEmpty()){
            
            if(!q.isEmpty() && q.peek().cVal != lastVal)
                pq.add(q.poll());

            
            if(!pq.isEmpty()){
                Node x = pq.poll();
                sb.append(alp[x.cVal]);
                lastVal = x.cVal;
                x.count--;
                if(x.count > 0)
                    q.add(x);
            }
            
        }
        
        
        return sb.toString();
    }
}