class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        
        for(int i = 0 ; i< queries.length; i++){
            int present = 0;
            for(int j= 0 ; j<points.length ;j++){
                if(inside(queries[i] , points[j])){
                present++;
             }
            }
            res[i] = present;
        }
        
        return res;
    }
    
    public boolean inside(int[] circle , int[] point){
        int x = point[0] , y = point[1] , Cx = circle[0] , Cy = circle[1] , R = circle[2];
        int dSq = (int)Math.pow(Cx - x , 2) + (int)Math.pow(Cy - y , 2);
        
        if(dSq <= (int)Math.pow(R,2))
            return true;
        else
            return false;
        
    }
    
}