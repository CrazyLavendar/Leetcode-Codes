class Solution {
    public int maxProfit(int[] prices) {
       
           int Tik0 = 0, Tik1 = Integer.MIN_VALUE;
        
        for(int price : prices){
            int Tik0Old = Tik0;
            Tik0 = Math.max(Tik0 , Tik1 + price); //sell
            Tik1 = Math.max(Tik1 , Tik0Old-price); // buy
            
        }
        
        return Tik0;
        
    }
}