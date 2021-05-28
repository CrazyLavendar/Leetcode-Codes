class Solution {
    public int maxProfit(int[] prices) {
        
        int Tik0 = 0, Tik1 = Integer.MIN_VALUE;
        
        for(int price : prices){
            Tik0 = Math.max(Tik0 , Tik1 + price); //sell
            Tik1 = Math.max(Tik1 , -price); // buy
            
        }
        
        return Tik0;
    }
}