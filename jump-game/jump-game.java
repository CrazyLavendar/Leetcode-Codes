class Solution {
    public boolean canJump(int[] nums) {
        
        int maxJump = nums[0];
        
        for(int i =1; i< nums.length ; i++){
            
            maxJump--;
            
            if(maxJump < 0)
                return false;
            
            if(maxJump < nums[i])
                maxJump = nums[i];
            
        }
        
        return true;
        
        
    }
}