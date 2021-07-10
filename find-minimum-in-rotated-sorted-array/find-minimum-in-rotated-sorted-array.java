class Solution {
    public int findMin(int[] nums) {
        int n= nums.length;
        
        if(n == 1 || nums[0] <= nums[n-1])
            return nums[0];

        
        int left = 0, right = n-1;
        while(left < right){
            
            int mid = (left + right) / 2;
            
            if(mid > 0 && nums[mid-1] > nums[mid]){
                return nums[mid];
            }
            
            if(nums[left] <= nums[mid] && nums[mid] > nums[right]){
                
                // System.out.println("Hi1" + " "+ left + " " + mid + " " + right);
                
                left = mid +1;
                
            }else{
                
                // System.out.println("Hi2" + " "+ left + " " + mid + " " + right);

                right = mid -1;
            }
            
        }
        
        return nums[left];
    }
}