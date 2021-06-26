class Solution {
    int time;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
     
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i =0 ; i<n ; i++)
            adj.add(new ArrayList<>());
        
        for(List<Integer> edge : connections){
            int u = edge.get(0) , v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        // System.out.println(adj);
        
        boolean[] vis = new boolean[n];
        int[] par = new int[n];
        int[] low = new int[n];
        int[] disc = new int[n];
        List<List<Integer>> res = new ArrayList<>();
        
        time = 0;
        for(int i =0 ; i< n ; i++){
            if(!vis[i]){
                dfs(adj, res, vis , par , low , disc, 0 , -1);
            }
        }
        
        // for(int i = 0; i< n; i++){
        //     System.out.println( i + " " +disc[i] + " " + low[i] + " " +par[i]);
        // }
        
        return res;
        
    }
    
    public void dfs(List<List<Integer>> adj , List<List<Integer>> res , boolean[] vis , int[] par, int[] low , int[] disc , int u , int parent){
        
        if(vis[u])
            return;
        
        disc[u] = low[u] = time++;
        vis[u] = true;
        
        for(int v : adj.get(u)){
            if(!vis[v]){
                par[v] = u;
                dfs(adj, res, vis , par , low , disc, v , u );
                low[u]  = Math.min(low[u], low[v]);
              if(low[v] > disc[u]){
                    res.add(new ArrayList<>(Arrays.asList(u,v)));
                }
            }
            else if(v != par[u]){
                low[u]  = Math.min(low[u], disc[v]);
            }
        }
    }
}