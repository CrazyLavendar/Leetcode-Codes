class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i =0 ; i< nums.length - 3; i++){
            for(int j =i+1; j < nums.length -2 ;j++){
                
                int left = j+1, right = n -1;
                    while(left < right){


                    if(nums[i] + nums[j] + nums[left] + nums[right] == target){
                        if(!res.contains(new ArrayList<>(List.of(nums[i] , nums[j] , nums[left] , nums[right]))))
                            res.add(new ArrayList<>(List.of(nums[i] , nums[j] , nums[left] , nums[right])));
                        while(left < right && nums[left] == nums[left + 1])left++;
                        left++;
                        while(left < right && nums[right] == nums[right -1])right--;
                        right--;

                    }
                    else if(nums[i] + nums[j] + nums[left] + nums[right] > target){
                        right--;
                    }
                    else{
                        left ++;
                    }
                }
                
            }
        }
        
        return res;
    }
}