class Solution {
    
    int k;
    public int[][] matrixBlockSum(int[][] mat, int k) {
        
        this.k = k;
        int m = mat.length , n =mat[0].length ;
        int[][] res = new int[m][n];
        for(int i =0 ; i< m ;i++){
            for(int j =0 ; j< n ;j++){
                res[i][j] = solve(i , j , mat);
            }
        }
        return res;
    }
    
    public int solve(int row , int col , int[][] mat){
        
        int res =0 ;
        int m = mat.length , n =mat[0].length ;
        for(int i = row -k; i<= row+k ; i++){
            for(int j =col - k ; j<= col + k ;j++){
                if(i>=0 && i<m  && j>=0 && j<n)
                    res += mat[i][j];
            }
        }
        return res;
    }
}