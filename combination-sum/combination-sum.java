class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>>res = new ArrayList<>(); 
        
        backtrack(res , new ArrayList<>() , candidates , target , 0);
        
        return res;
        
    }
    
    public void backtrack(List<List<Integer>> res , List<Integer> curr ,int[] candidates, int balance , int pos){
        
        
        
        if(balance == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        else if(balance < 0){
            return;
        }
        else{
            for(int i =pos ; i< candidates.length ; i++){
                
                // balance -= candidates[i];
                
                curr.add(candidates[i]);
                backtrack(res , curr , candidates , balance - candidates[i]  , i);
                curr.remove(curr.size() - 1);
                // balance += candidates[i];
                
            }
            
        }
        
    }
}