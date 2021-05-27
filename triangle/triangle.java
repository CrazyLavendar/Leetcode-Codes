class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int len = triangle.size();
        System.out.println(len);
        
        for(int i = len - 2 ;i >= 0; i-- ){
            for(int j = 0; j< triangle.get(i).size() ; j++){
                
                int temp = Math.min(triangle.get(i+1).get(j) ,triangle.get(i+1).get(j+1));
                
                triangle.get(i).set(j , triangle.get(i).get(j) + temp);
                
            }
        }
        
        // System.out.println(triangle);
        
        return triangle.get(0).get(0);
    }
}