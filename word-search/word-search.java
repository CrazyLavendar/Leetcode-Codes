class Solution {
    
    int[][] dirs = new int[][]{{-1,0} , {0,1} , {1,0} , {0 ,-1}};
    int m ,n;
    public boolean exist(char[][] board, String word) {
        
        m = board.length;
        n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i =0 ; i< m ; i++){
            for(int j =0; j<n ; j++){
                if(dfs(board , i , j , word ,0 , vis))
                    return true;
            }
        }
        
        return false;
    }
    
    public boolean dfs(char[][] board , int x ,int y , String word, int ind , boolean[][] vis){
        if(ind == word.length()){
           return true; 
        }
        
        if(x < 0 || y < 0 || x >= m || y>= n || vis[x][y] || board[x][y] != word.charAt(ind))
            return false;

        
        vis[x][y] = true;
        boolean res = false;
        for(int[] dir : dirs){
            
            res = res || dfs(board , x + dir[0] , y + dir[1] , word, ind + 1 , vis);
            
        }
        vis[x][y] = false;
        return res;
    }
}