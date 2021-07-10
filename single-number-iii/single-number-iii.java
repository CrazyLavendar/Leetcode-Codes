class Solution {
    public int[] singleNumber(int[] nums) {
        
        int xor = 0;
        for(int x : nums)
            xor ^= x;
        
        int rsb = xor & (-xor);
        System.out.println(xor + " " + rsb );
        
        int x = 0 , y =0;
        for(int num : nums){
            
            if((rsb & num) > 0)
                x ^= num;
            else
                y ^= num;
            
            
        }
        
        
        return new int[]{x,y};
    }
}