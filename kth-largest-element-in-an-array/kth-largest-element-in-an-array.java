class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        
        
        
        int left = 0 , right = nums.length -1 , n = nums.length - k;
        while(left  <= right){
            
            
             swap(nums , left , (left+right)/2);
            
            int pivot = pivot(nums , left , right);
            if(pivot == n)
                return nums[pivot];
            else if(pivot < n){
                left = pivot +1;
                
            }else{
                right = pivot -1;
            }
            
           
            
            
        }
    
        return 0;
        
        
    }
    
    public int pivot(int[] nums , int left , int right){
        
        int select = nums[left];
        int i = left+1 , j = left +1;
        while( i <= right ){
         if(nums[i] <= select){
             swap(nums , i , j);
             j++;
         }
         i++;    
        }
        swap(nums , left , j-1);
        return j-1;
         
    }
    public void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
    }
    
    
}