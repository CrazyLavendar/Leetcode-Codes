class Solution {
    public int subarraySum(int[] nums, int k) {
        int l = nums.length;
        int[] sums = new int[l];
        
        int total =0;
        for(int i =0 ; i< l ;i++){
            total += nums[i];
            sums[i] = total;
        }
        
        // int[][] mem = new int[l][l];
        int res = 0;
        for(int i =0; i< l; i++){
            for(int j=i; j< l ; j++){
                // mem[i][j] = sums[j] - sums[i] + nums[i];
                if(k == sums[j] - sums[i] + nums[i])
                    res++;
            }
        }
        
        
//            for(int i =0; i< l; i++){
//             for(int j=i; j< l ; j++){
//                 // if(res)
//                 // mem[i][j] = sum[j] - sum[i];
//                 System.out.print(mem[i][j] + " ");
//             }
//               System.out.println("");
//         }
        
        return res;
        
    }
}