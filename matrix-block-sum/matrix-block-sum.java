class Solution {
    
    public static int[][] dirs =  {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int k;
    public int[][] matrixBlockSum(int[][] mat, int k) {
        
        this.k = k;
        if(k==0)
            return mat;
        
        
        int m = mat.length , n =mat[0].length ;
        
        int[][] res = new int[m][n];
        
        
        for(int i =0 ; i< m ;i++){
            for(int j =0 ; j< n ;j++){
                int[][] visited = new int[m][n];
                res[i][j] = solve(i , j , mat);
            }
        }
        
        return res;
    }
    
    public int solve(int row , int col , int[][] mat){
        
         // System.out.println(row + " " + col);
        // add all row
        int res =0 ;
        int m = mat.length , n =mat[0].length ;
        for(int i = row -k; i<= row+k ; i++){
            for(int j =col - k ; j<= col + k ;j++){
                // System.out.println(row + " " + col + " " +i + " " + j);
                if(i>=0 && i<m  && j>=0 && j<n)
                res += mat[i][j];
            }
            
        }
        
   
        return res;
    }
}