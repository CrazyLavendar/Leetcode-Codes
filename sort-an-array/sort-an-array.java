class Solution {
    public int[] sortArray(int[] nums) {
        
        mergeSort(nums, 0 , nums.length -1);   
        return nums;
    }
    
    
    public void mergeSort(int[] nums , int left , int right){
        if(left == right)
            return;
        int mid = (left + right)/2;
        mergeSort(nums , left , mid);
        mergeSort(nums, mid+1,right);
        merge(nums , left , mid , right);
    }
    public void merge(int[] nums  , int left , int mid , int right){
        if(nums[mid] < nums[mid+1])
            return;
        int[] temp = new int[right - left + 1];
        int tempIndex = 0;
        int i = left , j = mid+1;
        while(i <= mid && j <= right){
        temp[tempIndex++] = nums[i] < nums[j]? nums[i++]:nums[j++];
        }
        while(i<=mid){
        temp[tempIndex++] = nums[i++];
        }
         while(j<=right){
        temp[tempIndex++] = nums[j++];
        }
        System.arraycopy(temp , 0 , nums , left , right - left + 1);
    }
    
    
}