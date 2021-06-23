class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        
        // System.out.println(pivotPartition(nums , 0 , nums.length - 1));
        
        // for(int x : nums)
        //     System.out.print(x + " ");
        
        
        
        int index = nums.length - k ;
        int start = 0 , end = nums.length -1;        
        
         while (start < end) {
            int pivot = pivotPartition(nums, start, end);
            if (pivot < index) start = pivot + 1; 
            else if (pivot > index) end = pivot - 1;
            else return nums[pivot];
        }
        
        return nums[start];
        
    }
    
    public int pivotPartition(int[] nums , int start , int end){
        int pivot = start; // Choose Pivot
        int i = start +1 ,j = i;
        
        for( ; j<= end ; j++){
            
            if(nums[j] < nums[pivot]){
                
                swap(nums, i++ , j);
                
            }
            
        }
        
        swap(nums , pivot , i-1);
        
        return i-1;
    }
    
    public void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}