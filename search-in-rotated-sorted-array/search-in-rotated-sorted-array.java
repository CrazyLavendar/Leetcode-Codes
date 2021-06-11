class Solution {
    public int search(int[] nums, int target) {
        
        
        int pivot =  findPivot(nums , 0 , nums.length -1);
        
        if(pivot == -1 || pivot == nums.length -1)
            return binarySearch(nums , 0 , nums.length -1 , target);

        if(target < nums[0]){
                    // System.out.println(pivot + 1 + " " + (nums.length -1 ) );
             return binarySearch(nums , pivot +1 , nums.length -1 , target);
        }
        return binarySearch(nums , 0 , pivot , target);
        
    }
    
    public int findPivot(int[] nums, int left , int right){
        
        if(left > right)
            return -1;
        
        if(left == right)
            return left;
        
        int mid = (left + right) /2;
        
        if(mid < right && nums[mid] > nums[mid +1])
            return mid;
        
        if(mid > left && nums[mid] < nums[mid -1])
            return mid -1;
        
        if(nums[left] > nums[mid])
            return findPivot(nums , left , mid -1);
        return findPivot(nums , mid+1 , right);
        
    }
    
    public int binarySearch(int[] nums, int left , int right , int target){
        
        if(left > right)
            return -1;
        
        int mid = (left + right) / 2;
        
        // System.out.println("mid : " + mid + " left " + left + " rigth : " + right);
        if(target == nums[mid])
            return mid;
        else if(target > nums[mid])
            return binarySearch(nums , mid +1 , right , target);
        else
            return binarySearch(nums , left , mid -1 , target);
        
        
    }

}