class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length  , n  = nums2.length;

        if(m==0)
           return median(nums2);
        if(n==0)
            return median(nums1);
        if(m > n)
            return findMedianSortedArrays(nums2 , nums1);
        
        int low = 0 , high = m;
        
        while(low <= high){
            
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1)/2 - partitionX;
            
            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX -1];
            int minRightX = partitionX == m ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = partitionY <= 0 ? Integer.MIN_VALUE : nums2[partitionY -1];
            int minRightY = partitionY >= n ? Integer.MAX_VALUE : nums2[partitionY];
           
            
            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                  
                if((m+n)%2 == 0){
                    // System.out.println(maxLeftX + " " + maxLeftY  + " " + minRightX + " " + minRightY);
                    int left = Math.max(maxLeftX , maxLeftY);
                    int right = Math.min(minRightX , minRightY);
                    // System.out.println(left + " " + right);
                    return ((double)left + (double)right)/2;
                }else{
                    return Math.max(maxLeftX , maxLeftY);
                }
                
            }
            else if(maxLeftX > minRightY){
                high = partitionX - 1;
            }
            else{
                low = partitionX + 1;
            }
        }

        return 0;
    }
    
    public double median(int[] nums){
        int n = nums.length;
        int mid = n/2;
            if(n%2==0){
                double val = nums[mid-1] + nums[mid];
                return (double)val/2.0;
            }else{
                return nums[mid];
            }
    }
    

}