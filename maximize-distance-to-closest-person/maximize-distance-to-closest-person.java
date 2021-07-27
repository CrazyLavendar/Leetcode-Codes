class Solution {
    public int maxDistToClosest(int[] seats) {
       
        
        //Check corner
        
        int n = seats.length;
        
        int i =0 , res =0;
        
        while(i < n){
            if(seats[i++] == 1)
                break;
        }
        
        res = Math.max(res , i-1);
        
        i = n-1;
        
        // System.out.println(res);
        while(i >= 0){
            
            if(seats[i--] == 1)
                break;
            
            
        }
        
        res = Math.max(res , n-1-i-1);
           // System.out.println(res);
        int gap =0, maxGap = 0;
        for(i = 1 ; i < n-1 ; i++){
            
            if(seats[i] == 1){  
                gap = 0;
            }else{
                gap++;
            }
            maxGap = Math.max(gap , maxGap);

        }
        
        
        res = Math.max(res , (maxGap+1)/2);
           // System.out.println(res);
        return res;
    }
}