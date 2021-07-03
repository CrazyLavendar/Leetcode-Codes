class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        
        int left = 0 , right = arr.length -1;
        boolean xFound  = false;
        
        int mid = -1;
        while(left < right){
            mid = (left+right) / 2;
            if(arr[mid] == x){
                xFound = true;
                break;
            }
            else if(arr[mid] < x && arr[mid +1] > x){
                // System.out.println("HI");
                break;
            }
            else if(arr[mid] < x ){
                // System.out.println("HI2 " + mid);
                if(mid+1 >= right)
                    break;
                left = mid+1;
                
            }else{
                
                if(left >= mid-1)
                    break;
                right = mid-1;
            }
        }

                   // System.out.println(left + " "+ mid +" " + right + " "  + arr[left] + " " + arr[right]);
        
        
        List<Integer> res = new ArrayList<>();
        
        if(xFound){
            res.add(arr[mid]);
            left = mid -1;
            right = mid +1;
        }
        else{
            left = mid;
            right = mid+1;
        }
            
        while(res.size() < k){
            
            if(left == -1){
                res.add(arr[right]);
                right++;
            }
            else if(right == arr.length){
                res.add(arr[left]);
                left--;
                
                
            }else{
                // System.out.println(left + " "+ mid +" " + right + " "  + arr[left] + " " + arr[right]);
                
                if(Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)){
                    res.add(arr[left]);
                    left--;
                }
                else{
                    res.add(arr[right]);
                    right++;
                }
                
                
            }

            
        }        
        
        Collections.sort(res);
        
        
        return res;
    }
    

}