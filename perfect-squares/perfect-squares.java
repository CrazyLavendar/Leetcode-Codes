class Solution {
    int res ;
    public int numSquares(int n) {
//         res = n;
//         int nums[] = new int[100];
        
//         for(int i = 0 ; i< 100;i++)
//             nums[i] = (i+1)*(i+1);
        
//         dfs(nums , new ArrayList<>() , 0 , n);
//         return res;
        
                int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }
    
    public void dfs(int[] nums, List<Integer> temp,int index,int t){
        if(t==0 && temp.size() < res){
            res = temp.size();
            return;
        }
        
        if(t < 0)
            return;
        
        for(int i = index ; i< nums.length ; i++){
            if(nums[i] > t) break;
            temp.add(nums[i]);
            dfs(nums , new ArrayList<>(temp) , i ,t - nums[i]);
             temp.remove(temp.size() - 1);
        }
    }
    
}