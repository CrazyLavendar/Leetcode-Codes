class Solution {
    char[][] board;
    int n;
    public List<List<String>> solveNQueens(int n) {
       this.n = n;
        List<List<String>> res = new ArrayList<>();
        board = new char[n][n];
        
        for(int i =0 ; i< n ; i++)
            for(int j = 0; j< n ; j++)
                board[i][j] = '.';
        // res.add(printBoard());
        dfs(0 , res);
        
        return res;
    }
    
    public void dfs(int col , List<List<String>> res){
        if(col == n){
            res.add(printBoard());
            return;
        }
        for(int row = 0 ; row <n ; row++){
            if(validate(row , col)){
                board[row][col] = 'Q';
                dfs(col + 1 , res);
                 // res.add(printBoard());
                board[row][col] = '.';
                
            }
           
            
        }
        
    }
    
      private boolean validate( int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < y; j++) {
                if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }
        
        return true;
    }
    
    private boolean isPlaceValid(int x, int y) {

        if(x >=n || y>=n || x < 0 || y < 0)
            return false;
        
        for(int i = y -1 ; i >=0 ; i--)
            if(board[x][i] == 'Q')
                return false;
        
         
        for(int i = x-1 ; i >=0 ; i--)
            if(board[i][y] == 'Q')
                return false;
        
        
        for(int i = x -1, j = y-1 ; i>=0 && j >= 0 ; i-- , y--){
            if(board[i][j] == 'Q')
                return false;
        }
            
        for(int i = x +1, j = y-1 ; i < n && j >= 0 ; i++ , y--){
            if(board[i][j] == 'Q')
                return false;
        }
        return true;
    }
    
    
    public List<String> printBoard(){
    
        List<String> current = new ArrayList<>();
        for(int i = 0; i<n ; i++){
          String str = "";
            for(int j =0 ; j<n ; j++)
                str += board[i][j];
            current.add(str);
        }
        
        return current;
    }
        


}

