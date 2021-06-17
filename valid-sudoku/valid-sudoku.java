class Solution {
    
    char[][] board;
        
    public boolean isValidSudoku(char[][] board) {
        
        this.board = board;
        return isValid();
    }
    
    public boolean isValid(){
        return rowCheck() && colCheck() && subBox();
    }
    
    public boolean rowCheck(){
        
        
        for(int i = 0; i< 9 ; i++){
            
            Set<Character> set = new HashSet<>();
            
            for(int j =0 ; j < 9 ; j++){
                
                if(board[i][j] == '.')
                    continue;
                else if(!set.contains(board[i][j]))
                    set.add(board[i][j]);
                else{
                    // System.out.println("Row");
                    return false;
                }
                    
            }
        }
        
        
        return true;
    }
    public boolean colCheck(){
        
                
        for(int j = 0; j< 9 ; j++){
            
            Set<Character> set = new HashSet<>();
            
            for(int i =0 ; i < 9 ; i++){
                
                if(board[i][j] == '.')
                    continue;
                else if(!set.contains(board[i][j]))
                    set.add(board[i][j]);
                else{
                    // System.out.println("Col");
                    return false;
                }
            }
        }
        
        
        return true;
    }
    public boolean subBox(){
        boolean res = true;
        for(int i =0 ; i < 9; i =i+3){
            for(int j =0 ; j < 9 ; j = j+3){
                res &= subBoxCheck(i,j);
            }
        }
        return res;
    }
    public boolean subBoxCheck(int x , int y){
        
    Set<Character> set = new HashSet<>();
        
        for(int i = x ; i < x + 3 ; i++){
            for(int j = y ; j< y + 3 ; j++){
                                
                if(board[i][j] == '.')
                    continue;
                else if(!set.contains(board[i][j]))
                    set.add(board[i][j]);
                else{
                    
                    // System.out.println("SubBox");
                    return false;
                }
                    
            }
        }
        
        
        return true;
    }
    
    
}