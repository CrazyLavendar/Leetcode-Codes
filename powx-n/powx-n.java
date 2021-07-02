class Solution {
    public double myPow(double x, int n) {
        
        // if(n==0)
        //     return 1;
        // else if(n > 0){
        //     return n%2 == 0 ? myPow(x*x , n/2) : x * myPow(x*x , n/2);
        // }
        // else{
        //      return n%2 == 0 ? myPow(1/(x*x) , n/2) : (1/x) * myPow(1/(x*x), n/2);
        // }
        
        return helper(x , (long)n);
        
    }
    
    public double helper(double x, long n) {
        
        if(n==0)
            return 1;
        
        if(n<0){
            n = -n;
            x = 1/x;
            
        }
       return n%2 == 0 ? helper(x*x , n/2) : x * helper(x*x , n/2);
        
    }
    
    
}