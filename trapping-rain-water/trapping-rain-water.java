class Solution {
    public int trap(int[] height) {
        
        int res  = 0, temp = 0;
        
        int pillar1 = 0, cur = 0; 

        for(int i  =0 ;i<height.length ; i++){
            
            cur = height[i];
            
            if(pillar1 == cur  || (pillar1 != 0 && pillar1 < cur)) {
                res = res + temp;
                temp = 0;
            }
            if(pillar1 < cur ) {
                pillar1 = cur;
                continue;
            }
            
            if(cur < pillar1){
                temp = (pillar1 - cur) + temp;
            }

    }
        
        pillar1 = 0;cur = 0;temp=0;
    for(int i  = (height.length - 1) ;i>=0 ; i--){
            
            cur = height[i];
            
            if((pillar1 != 0 && pillar1 < cur)) {
                res = res + temp;
                temp = 0;
            }
            if(pillar1 < cur ) {
                pillar1 = cur;
                continue;
            }
            
            if(cur < pillar1){
                temp = (pillar1 - cur) + temp;
            }

    }
        
               return res;
               }
               }
               
