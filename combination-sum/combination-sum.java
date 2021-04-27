class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Arrays.sort(candidates);
        List<List<Integer>> res= new ArrayList<>();
        backtrack(res , new ArrayList<>(),candidates , target , 0);
        // HashSet<List<Integer>> set = new HashSet<>(res);
        // List<List<Integer>> list = new ArrayList<>(res);
        return res;
    }
    
    public void backtrack(List<List<Integer>> res ,List<Integer> temp, int[] candidates, int target , int pos){
        if(target ==0)
            res.add(temp);
        if(target < 0)
            return;
        
        for(int i = pos ; i<candidates.length ; i++){
            temp.add(candidates[i]);
            backtrack(res , new ArrayList<>(temp) , candidates , target - candidates[i], i);
            temp.remove(temp.size() - 1);

            
        }
        
    }
}