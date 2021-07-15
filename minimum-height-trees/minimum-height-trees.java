class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        if(edges.length == 0)
            return new ArrayList<>(Arrays.asList(0));
        
        List<Set<Integer>> adj = new ArrayList<>();
        
        for(int i =0; i< n ; i++)
            adj.add(new HashSet<>());
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
             adj.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        
        for(int i = 0 ; i<n ; i++){
            if(adj.get(i).size() == 1)
                leaves.add(i);
        }
        // System.out.println(leaves);
        while(n>2){
            
            n -=leaves.size();
            
            List<Integer> newLeaves = new ArrayList<>();
            
            for(int i : leaves){
                
                int j = adj.get(i).iterator().next();
                adj.get(i).clear();
                adj.get(j).remove(i);
                if(adj.get(j).size() == 1)
                    newLeaves.add(j);

            }
            leaves = newLeaves;
            // System.out.println(leaves);
        }
        
        
        
        List<Integer> res = new ArrayList<>();
        
        return leaves;
    }
}