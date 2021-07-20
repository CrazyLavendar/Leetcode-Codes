class Solution {
    int res = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
      
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i =0; i< n ; i++)
            adj.add(new ArrayList<>());
        
        boolean[] vis = new boolean[n];
        
        for(int i = 0 ; i< n ; i++){
            if(manager[i] != -1){
                // adj.get(i).add(manager[i]);
                adj.get(manager[i]).add(i);
            }
        }
        
        vis[headID] = true;
        
        
        dfs(adj , headID , informTime[headID], vis ,  informTime);
        
        // System.out.println(adj);        
        
        return res;
    }
    
    public void dfs(List<List<Integer>> adj, int currID, int resTime , boolean[] vis , int[] informTime ){
        
        if(adj.get(currID).size() == 0){
            res = Math.max(res , resTime );
            return;
        }
        
        // System.out.println(currID + " " + (resTime +informTime[currID]) );
        
        for(int sub : adj.get(currID)){
            
            dfs(adj , sub , resTime +informTime[sub] , vis , informTime );
            
        }
    }
}