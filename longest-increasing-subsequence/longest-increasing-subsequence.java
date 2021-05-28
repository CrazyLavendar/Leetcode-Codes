public class Solution {

    
    //N^2
//     public int lengthOfLIS(int[] nums) {
//         // return lengthofLIS(nums, Integer.MIN_VALUE, 0);
        
//         int len = nums.length;
//         int[] dp = new int[len];
//         int res = 1;
//         for(int i = 0 ;i< len ; i++){
            
//             dp[i] = 1;
//             for(int j = 0 ; j<i ; j++){
                
//                 if(nums[j] < nums[i]){
                    
//                     dp[i] = Math.max(dp[i] , 1 + dp[j]);
//                 }
                
                
//             }
//             res = Math.max(res , dp[i]);
            
//         }
        
//         return res;
    
    
    
    //nlogn
    
    public int lengthOfLIS(int[] nums) {
    int[] tails = new int[nums.length];
    int size = 0;
    for (int x : nums) {
        int i = 0, j = size;
        while (i != j) {
            int m = (i + j) / 2;
            if (tails[m] < x)
                i = m + 1;
            else
                j = m;
        }
        tails[i] = x;
        if (i == size) ++size;


//         for(int xx : tails)
//             System.out.print(xx + " , ");
// System.out.println("");
    }
    return size;

// Runtime: 2 ms
        
    }


}