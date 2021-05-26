class Solution {
    
//     public List<List<Integer>> subsets(int[] nums) {
//     List<List<Integer>> list = new ArrayList<>();
//     Arrays.sort(nums);
//     backtrack(list, new ArrayList<>(), nums, 0);
//     return list;
// }

// private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
//     list.add(new ArrayList<>(tempList));
//     for(int i = start; i < nums.length; i++){
//         tempList.add(nums[i]);
//         backtrack(list, tempList, nums, i + 1);
//         tempList.remove(tempList.size() - 1);
//     }
// }
    public List<List<Integer>> subsets(int[] nums) {
        
            Arrays.sort(nums);
         List<List<Integer>> res = new ArrayList<>();
        
        backtrack(res, new ArrayList<>() , nums , 0);
        
        return res;
    }
    
    
    public void backtrack(List<List<Integer>> res,  List<Integer> curr , int[] nums , int index){
        
         res.add(new ArrayList<>(curr));
        
        // System.out.println(res);
        // if(curr.size() == nums.length || index == nums.length){
        //     return;
        // }
        
        for(int i = index; i< nums.length ; i++){
            // if(curr.contains(nums[i]))continue;
            curr.add(nums[i]);
            backtrack(res, curr, nums, i +1 );
            curr.remove(curr.size() - 1);
            
        }
    }
}