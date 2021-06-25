class Solution {


    public int largestRectangleArea(int[] height) {
        int res = 0;
        // for(int i =0 ; i< height.length ; i++){
        //     res = Math.max(res , findArea(i , height));
        // }
        
        int n = height.length;
        int[] leftLowest = new int[n];
        
        Stack<Integer> s = new Stack<>();
        int currLowest = -1;
        for(int i =0 ; i< n ; i++){
            if(s.isEmpty()){
                currLowest = i;
                leftLowest[i] = i;
                s.push(i);
            }
            else{
                if(height[s.peek()] < height[i]){
                    // System.out.println(i + " "+  s.size() + " " + s.peek() + " " + height[i]);
                    leftLowest[i] = i;
                    s.push(i);
                }
                else{
                    int lastPop = -1;
                    while(!s.isEmpty() && height[s.peek()] >= height[i]){
                        lastPop = s.peek();
                        s.pop();
                    }
                    if(s.isEmpty())
                        leftLowest[i] = 0;
                    else
                        leftLowest[i] = s.peek() + 1;
                    s.push(i); 
                }
            }
        }
        
        s.clear();
        
        int[] rightLowest = new int[n];
        for(int i = n-1; i>= 0 ; i--){
            if(s.isEmpty()){
                rightLowest[i] = i;
                s.push(i);
            }
            else{
                if(height[s.peek()] < height[i]){
                    // System.out.println(i + " "+  s.size() + " " + s.peek() + " " + height[i]);
                    rightLowest[i] = i;
                    s.push(i);
                }
                else{
                    int lastPop = -1;
                    while(!s.isEmpty() && height[s.peek()] >= height[i]){
                        lastPop = s.peek();
                        s.pop();
                    }
                    if(s.isEmpty())
                        rightLowest[i] = n-1;
                    else
                        rightLowest[i] = s.peek() -1;
                    s.push(i); 
                }
            }
        }
        
        
//         for(int x :  leftLowest)
//             System.out.print(x + " ");
        
//         System.out.println("");
//         for(int x :  rightLowest)
//             System.out.print(x + " ");
//         System.out.println("");
        
        for(int i =0 ; i< n ; i++){
            
            res = Math.max(res , height[i] * (rightLowest[i] - leftLowest[i] + 1));
        }

        
        return res;
    }
    
    
    public int findArea(int i , int[] nums){
        int left = i , right = i;
        while(left >= 0 && nums[left] >= nums[i]) left--;
        while(right < nums.length && nums[right] >= nums[i]) right++;
        return nums[i] * (right - left - 1);
    }
        
}