class Solution {
    public int findDuplicate(int[] nums) {
        

        int p = nums[0] , q = nums[0];
        
        do{
            p = nums[p];
            q = nums[nums[q]];
            // System.out.println(p + " " + q );
        }while(p!=q);
        
        p = nums[0];
        
        while(p != q){
            p = nums[p];
            q = nums[q];
        }
        
        
        return p;
    }
}