class Solution {
    public boolean validMountainArray(int[] arr) {
        
        boolean decreasing = false;
        
        
        int n = arr.length , i = 1;
        
        if(n >=2){
            if(arr[0] > arr[1])
                return false;
        }
        
        while(i < n){
            
            if(arr[i-1] > arr[i]){
                decreasing = true;
                break;
            }else if(arr[i-1] == arr[i]){
                return false;
            }
            
            i++;
            
            
        }
        
        if(!decreasing)
            return false;
              // System.out.println("HI" + " " + i);
  
        i++;
        while(i < n){
            
        if(arr[i-1] <= arr[i]){
                  // System.out.println("HI" + " " + i);
                return false;
            }
            
            i++;
            
            
        }
        
        return true;
    }
}