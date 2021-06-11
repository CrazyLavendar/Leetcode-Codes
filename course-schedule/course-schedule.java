class Solution {
    public boolean canFinish(int n, int[][] pre) {
      
        int[] vis = new int[n];
        Arrays.fill(vis , -1);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0 ; i< n ; i++)
         adj.add(new ArrayList<>());   
        
        for(int i =0 ; i<pre.length ; i++){
            adj.get(pre[i][0]).add(pre[i][1]);
        }
        
        
        for(int i =0 ; i < n ; i++){
            
            if(vis[i] == -1)
                if(dfsCycle(adj , i , vis))
                    return false;
            
        }
        
            
        return true;
    }
    
    public boolean dfsCycle(ArrayList<ArrayList<Integer>> adj , int u , int[] vis){
        
        if(vis[u] == 1) // Popped from stack
            return false;
        
        if(vis[u] == 0) // At Stack
            return true;
        
        vis[u] = 0;
        
        
        for(int i =0 ; i< adj.get(u).size() ; i++){
            
            if(dfsCycle(adj , adj.get(u).get(i) , vis))
                return true;
            
        }
        
        vis[u] = 1;
        
        return false;
    }
}