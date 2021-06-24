class Solution {
    public int[] findOrder(int N, int[][] pre) {
        
        int[] vis = new int[N];
        
        Arrays.fill(vis , -1);  // -1 not visted , 0 , visited & @ stack , visited and popped
        
        List<Integer> res = new ArrayList<>();
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0 ; i< N ; i++)
            adj.add(new ArrayList<>());
        
        for(int[] edge : pre){
            adj.get(edge[0]).add(edge[1]);
        }
        
        // System.out.println(adj);
        
        for(int i= 0 ; i< N ; i++){
            if(vis[i] == -1){
                if(!dfs(adj , vis, res , i))
                    return new int[]{};
            }
        }
        
        
        return res.stream().mapToInt(i->i).toArray();
    }
    
    public boolean dfs(List<List<Integer>> adj ,int[] vis , List<Integer> res , int u){
        if(vis[u] == 1)
            return true;
        if(vis[u] == 0)
            return false;
        
        vis[u] = 0;
        
       
        
        boolean ans = true;
        
        for(int v : adj.get(u)){
            
            ans &= dfs(adj, vis , res , v);
        }
        res.add(u);
        // System.out.println("Hi " + u);
        vis[u] = 1;
        
        return ans;
    }
}