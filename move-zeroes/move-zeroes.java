class Solution {
    public void moveZeroes(int[] nums) {
        
        int j= nums.length-1 , i =0;
        while(i < j){
            if(nums[i] != 0){
                i++;
            }else{
                for(int start = i ; start < j ; start++)
                    nums[start] = nums[start+1];
                
                nums[j] = 0;
                j--;
            }
        }
        
    }
}