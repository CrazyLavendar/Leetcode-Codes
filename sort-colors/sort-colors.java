class Solution {
    public void sortColors(int[] nums) {
        
        int r =0 , w = 0, b = 0;
        for(int x : nums){
            if(x==0)
                r++;
            else if(x==1)
                w++;
            else
                b++;
        }
        // System.out.println(r + " " + w + " " + b);
        for(int i =0 ; i < nums.length ;i++){
            if(r-- > 0){
                nums[i] = 0;
                continue;
            }
            if(w-- > 0){
                nums[i] = 1; 
                continue;
            }
            if(b-- > 0){
                nums[i] = 2; 
                continue;
            }
        }
        
    }
}