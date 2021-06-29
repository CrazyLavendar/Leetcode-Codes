class Solution {
    public int majorityElement(int[] nums) {
    
        int count = 0 , majority = -1;
        
        
        for(int x : nums){
            
            if(count == 0){
                count = 1;
                majority = x;
            }
            else if(x == majority)
                count++;
            else
                count--;
        }
        
        return majority;
    }
}