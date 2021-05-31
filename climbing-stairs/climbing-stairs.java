class Solution {
    public int climbStairs(int n) {
        
        int curr = 2, prev =1 ;
        if(n==1 || n==2)
            return n;
        else{
            for(int i = 3 ; i<= n ; i++){
                int temp = curr;
                curr += prev;
                prev = temp;
            }
                
        }
        return curr;
    }
}