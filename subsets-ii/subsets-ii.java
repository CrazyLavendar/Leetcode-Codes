class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
            Set<List<Integer>> list = new HashSet<>();
            Arrays.sort(nums);
            backtrack(list, new ArrayList<>(), nums, 0);
        
            
            List<List<Integer>> res = new ArrayList<>(list);
            return res;
    }
    
    public void backtrack(Set<List<Integer>> list , List<Integer> temp , int[] nums , int start){
        list.add(new ArrayList<>(temp));
        
        for(int i = start ; i< nums.length ; i++){
            temp.add(nums[i]);
            backtrack(list , temp , nums , i+1);
            temp.remove(temp.size()- 1);
        }
        
    }
}