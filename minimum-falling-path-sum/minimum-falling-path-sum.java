class Solution {
    int[][] matrix;
    int n;
    public int minFallingPathSum(int[][] matrix) {
        this.matrix = matrix;
        n = matrix.length ;
        
        int[][] mem = new int[n][n];
        

        
        for(int i =0; i< n ;i++){
            
            
            if(i!=0){
            for(int j=0; j<n ;j++){
                matrix[i][j] += mem[i-1][j];
            }
            }
            
            for(int j =0; j<n ;j++){
                mem[i][j] = update(i ,j);
            }
            
        }
        int min = Integer.MAX_VALUE;
        
        // for(int i =0 ; i<n;i++){
            for(int j =0; j< n ;j++){
                // System.out.print(matrix[i][j] +" ");
                if(min > matrix[n-1][j])
                    min = matrix[n-1][j];
            }
            // System.out.println("");
        // }
        
        return min;
        
    }
    
    public int update(int i , int j){
        int  a , b ,c;
        
       // System.out.println("i is , " + i+ " j is , " +j); 
        if(j==0)
            a = Integer.MAX_VALUE;
        else
            a = matrix[i][j-1];
        
        if(j==n-1)
            c = Integer.MAX_VALUE;
        else
            c = matrix[i][j+1];
        
        b = matrix[i][j];
        return Math.min(Math.min(a,b),c);
    }
}