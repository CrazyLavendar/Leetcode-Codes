class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[365+1];
        
        int day1Pass = Math.min(Math.min(costs[0] , costs[1]) ,costs[2]) ,
            day7Pass = Math.min(costs[1] , costs[2]),
            day30Pass = costs[2];
        
        boolean[] travel = new boolean[365 +1];
        
        for(int day : days)
            travel[day] = true;
        
        for(int i=1 ; i<=365 ; i++){
            if(!travel[i]){
                dp[i] = dp[i-1];
                continue;
            }
            
            dp[i] = day1Pass + dp[i-1]; // 1day ticket
            if(i>=7)
            dp[i] = Math.min (day7Pass + dp[i-7], dp[i]);
            if(i>=30)
            dp[i] = Math.min (day30Pass + dp[i-30], dp[i]);
            
            if(i<7)
                dp[i] = Math.min(dp[i], day7Pass);
            if(i<30)
                dp[i] = Math.min(dp[i] , day30Pass);
        }
            // for(int i=1 ; i<=365 ; i++){
            // if(travel[i]){
            //     System.out.println(i + " " +dp[i]);
            // }
        // }
        return dp[365];
        
    }
}