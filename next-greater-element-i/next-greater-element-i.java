class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        
        int[] greater = new int[nums2.length];
        Arrays.fill(greater , -1);
        
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0 ; i< nums2.length ; i++){
            
            if(s.isEmpty() || nums2[s.peek()]  > nums2[i]){
                s.push(i);
                continue;
            }
            else{
                
                while(!s.isEmpty()){
                    // System.out.println(s);
                    if(nums2[s.peek()] < nums2[i]){
                        greater[s.pop()] = nums2[i]; 
                    }
                    else{
           
                        break;
                    }
                }
               s.push(i);
            }
        }
        
        Map<Integer , Integer> map = new HashMap<>();
        
        for(int i =0; i< nums2.length ; i++){
            map.put(nums2[i] , greater[i]);
            
        }
        
        
        int[] res = new int[nums1.length];
        
        for(int i =0 ; i<nums1.length ; i++){
            res[i] = map.get(nums1[i]);
        }
        
        return res;
    }
}