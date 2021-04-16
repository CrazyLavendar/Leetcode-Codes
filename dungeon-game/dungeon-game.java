class Solution {
    int[][] dirs = new int[][]{{0,1} , {1,0}};
    int minHealth = Integer.MIN_VALUE;
    public int calculateMinimumHP(int[][] mat) {
        
        // Recursion  & Backtrack ----> TLE
        /*
        // int life = 0;
        // dfs(mat , 0 ,0, 0 ,0);
        // return minHealth <= 0 ? Math.abs(minHealth) + 1 : 0;
        */
        int m = mat.length, n =mat[0].length;
        int[][] health = new int[m][n];
       
        if(mat[m-1][n-1] >= 0)
            health[m-1][n-1] = 0;
        else
            health[m-1][n-1] = mat[m-1][n-1];
        
        for(int i =m -2; i >=0 ; i--){
           if(mat[i][n-1] + health[i+1][n-1] > 0)
               health [i][n-1] = 0;
              else
                health[i][n-1] = mat[i][n-1] + health[i+1][n-1];
       }
        
        for(int j= n-2 ; j >=0; j--){
            if(mat[m-1][j] + health[m-1][j+1] >0)
                health[m-1][j] = 0;
            else
                health[m-1][j] = mat[m-1][j] + health[m-1][j+1];
        }
        
        for(int i = m-2; i>=0 ;i--){
            for(int j = n-2; j>=0; j--){
                health[i][j] = Math.max(health[i+1][j] , health[i][j+1]) + mat[i][j] ;
                if(health[i][j] > 0)
                    health[i][j] = 0;
             
            }
        }
        
//         for(int i =0; i < m ; i++){
//             for(int j=0 ; j< n; j++){
//                 System.out.print(health[i][j] + " ");
//             }
//             System.out.println("");
//         }
        return Math.abs(health[0][0]) +1;
        
    }
    
    public void dfs(int[][] mat ,int i , int j ,int pain , int health) {
        int m = mat.length, n =mat[0].length;
        health += mat[i][j]; //curr health
        pain = Math.min(pain , health); // curr min damage
        if(i==m-1 && j==n-1){
           minHealth = (minHealth < pain)? pain : minHealth;
            return ;
        }
        for(int[] dir : dirs){
            int x =   i + dir[0] , y = j + dir[1];
            if(x >=m || y>= n) continue;
            dfs(mat , x , y , pain , health);            
        }
    }
}