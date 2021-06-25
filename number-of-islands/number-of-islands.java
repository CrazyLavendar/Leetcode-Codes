class Solution {
    int m , n;
    int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
    public int numIslands(char[][] grid) {
     
         m = grid.length ; n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        
        int island= 0;
        for(int i =0 ; i< m ; i++){
            for(int j =0 ; j < n ; j++){
                
                if(!vis[i][j] && grid[i][j] == '1'){
                    dfs(grid , i , j , vis);
                    island++;
                }
                
            }
        }
        
        return island;
        
    }
    
    public void dfs(char[][] grid , int x , int y , boolean[][] vis){
        if(x < 0 || y < 0 || x >= m || y >= n || vis[x][y] || grid[x][y] == '0')
            return;
        
        vis[x][y] = true;
        
        for(int[] dir : dirs){
            dfs(grid , x+ dir[0] , y+ dir[1] , vis);
        }
        
    }
    
    
}