class Solution {
    public int trap(int[] height) {
        if(height.length <3)
            return 0;
        
        int res  = 0, temp = 0; // final water trap & inbetween Trap 
        int pillar = height[0];
        
        for(int i  = 1 ;i<height.length ; i++){
            
            if(pillar <= height[i]) {
                pillar = height[i];
                res += temp;
                temp = 0;
            }
 
            else
                temp = (pillar - height[i]) + temp;
    }
        
        int maxPillarLeft = pillar;
        pillar = height[height.length - 1]; temp=0;
        for(int i =height.length - 1 ;i>=0 ; i--){
            
                if(height[i] == maxPillarLeft){
                    res += temp;
                    break;
                }
                if(pillar <= height[i]) {
                    pillar = height[i];
                    res += temp;
                    temp = 0;
                }
                else 
                   temp = (pillar - height[i]) + temp;

        }
        return res;
    }
}
               
