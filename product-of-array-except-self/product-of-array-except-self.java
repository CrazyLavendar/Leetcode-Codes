class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int product = 1;
        boolean zeroFound = false ;
        
        int[] res = new int[nums.length];
        for(int x : nums){
            
            if(x ==0  && zeroFound)
                return res;
            
            if(x!=0)
                product *= x;
            else
                zeroFound = true;
            

        }
        
      
        
        for(int i =0 ; i< nums.length ; i++){
            if(zeroFound && nums[i] != 0)
                res[i] = 0;
            else if(nums[i] ==0 )
                res[i] = product;
            else
                res[i] = product / nums[i];
        }
        return res;
    }
}