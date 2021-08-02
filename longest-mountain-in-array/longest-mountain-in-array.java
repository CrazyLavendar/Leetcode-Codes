class Solution {
    public int longestMountain(int[] arr) {
        
        boolean inc = false, dec = false, flag = false; 
        int routeUp = 0, routeDown =0;
        int res = 0;
        
        for(int i = 1; i < arr.length ; i++){
            
            if(!flag && arr[i-1] > arr[i])
                continue;
            
            if(arr[i-1] < arr[i]){
                
                flag = true;
                
                if(inc){
                    routeUp++;
                }else{
                routeUp = 2;
                routeDown = 0;
                inc = true;
                dec = false;
                }
            }else if(arr[i-1] > arr[i]){
                if(dec){
                    routeDown++;
                    
                }else{
                    routeDown = routeUp + 1;
                    routeUp = 0;
                    dec = true;
                    inc = false;
                    
                }
                
                res = Math.max(res , routeDown);
            }
            else{
                   inc = false; dec = false; flag = false;
                    routeUp = 0; routeDown =0;
            }
        }
        
        return res;
    }
}