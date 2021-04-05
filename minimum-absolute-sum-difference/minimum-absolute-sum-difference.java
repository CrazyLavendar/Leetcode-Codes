class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        
        int[] abs = new int[nums1.length];
        
        int maxAbs = 0 , index = -1;
        for(int i =0 ; i< nums1.length ; i++){
            abs[i] = Math.abs(nums1[i] - nums2[i]);
            
            if(maxAbs < abs[i]){
                maxAbs = abs[i];
                index = i;
            }
        }
        
        if(maxAbs ==0)
            return 0;
         // System.out.println(maxAbs + " " + index);
        int makeMin = maxAbs , indexVal = nums2[index], selectIndex = index;
        
        for(int i =0 ; i< nums1.length ; i++){
            
            if(makeMin > Math.abs(nums1[i] - indexVal)){
               makeMin =  Math.abs(nums1[i] - indexVal);
                selectIndex = i;
            }
            
        }
        
         // System.out.println(makeMin + " " + selectIndex);
        nums1[index] = nums1[selectIndex];
        int sum = 0;
        for(int i = 0 ; i< nums1.length; i++)
            sum = (sum + Math.abs(nums1[i] - nums2[i])) % 1000000007;
        // System.out.println(maxAbs + " " + index);
        return sum; 
    }
}