class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        
         List<List<Integer>> res = new ArrayList<>();
        
        backtrack(res , new ArrayList<>() , nums ,0);
        
        return res;
         
    }
    
    public void backtrack(List<List<Integer>> res , List<Integer> curr , int[] nums , int index){
        
        if(curr.size() == nums.length){
            
            res.add(new ArrayList<>(curr));
            return;
        }
        
        // else{
            
        for(int i =0; i< nums.length; i++ ){
            if(curr.contains(nums[i])) continue;
            curr.add(nums[i]);
            backtrack(res , curr, nums ,i +1);
            
            curr.remove(curr.size() - 1);
            
        }
        // }

        
    }
    
}