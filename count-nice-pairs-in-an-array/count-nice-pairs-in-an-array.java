class Solution {
    public int countNicePairs(int[] nums) {
        long nice =0 ;
        int[] temp =  new int[nums.length];
        
        for(int i =0 ; i< nums.length ; i++){
            temp[i] = nums[i] - reverse(nums[i]);
        }
        
        Arrays.sort(temp);
        long curr = 1;
        for(int  i =1 ; i< temp.length ; i++){
           if(temp[i] == temp[i-1])
               curr++;
            else{
                nice += (curr * (curr -1)) / 2;
                curr =1;
            }
            
        }
        nice += (curr * (curr -1)) / 2;
        
        int ans =(int) (nice % (1000000007));
        return ans;
    }
    
    public int reverse(int num){
        int reversed = 0;
      for(;num != 0; num /= 10) {
      int digit = num % 10;
      reversed = reversed * 10 + digit;
    }
        return reversed;
    }
}