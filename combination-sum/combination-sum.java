class Solution {
    int t;
    public List<List<Integer>> combinationSum(int[] can, int target) {
        t = target;
        List<List<Integer>> res = new ArrayList<>();
        
        backtrack( res ,new ArrayList<>() , 0, 0, can);
        
        return res;
        
    }
    
    public void backtrack(List<List<Integer>> res , List<Integer> curr , int index , int sum , int[] can){
        
        
        if(sum == t){
            
            res.add(new ArrayList<>(curr));
            return;
        }else if(sum > t){
            return;
        }else{
            
            for(int i = index ; i< can.length; i++){
                
                curr.add(can[i]);
                backtrack( res ,curr , i, sum+can[i], can);
                curr.remove(curr.size() -1);
            }
            
            
        }
        
    }
    
    
}