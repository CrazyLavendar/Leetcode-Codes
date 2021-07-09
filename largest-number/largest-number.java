class Solution {
    public String largestNumber(int[] nums) {
        
                
        int n = nums.length;
        
        if(n==1)
            return nums[0] + "";
        
        List<String> strs = new ArrayList<>();
        for(int i =0; i<n ;i++){
            strs.add(nums[i] + "");
        }
        
        Collections.sort(strs ,(a,b) -> myComparision(a,b));
        
        String res = "";
        for(int i =0; i<n ;i++){
            // strs[i] = nums[i] + "";
            
            if(i > 0 && strs.get(i).equals("0") && res.equals("0"))
                continue;
                
            res += strs.get(i);
            System.out.println(strs.get(i));
        }
        
        return res;
        
    }
    
    public int myComparision(String str1 , String str2){
        
//         if(a.equals(b))
//             return 0;
        
//         char[] aa = a.toCharArray() , bb = b.toCharArray();
//         int i=0 , j =0 , aLen = a.length() , bLen = b.length();
        
//         while(i<aLen && j <bLen){
            
//             if((int)aa[i] > (int) bb[j])
//                 return -1;
//             else if((int)aa[i] < (int)bb[j])
//                 return 1;
//             else{
//                 i++;
//                 j++;
//             }

//         }
                    
//             if(i == aLen){
                
//                i =1; 
                
               
//               while(i< aLen){
                  
//                   if((int)aa[i-1] > (int) aa[i])
//                       i++;
//                   else
//                       return -1;
//               }
//             return 1;
                
//             }
//             else{
                
//                 j = 1;
                    
//             while(j< bLen){
                
//                 if((int)bb[j-1] > (int) bb[j])
//                       j++;
//                   else
//                       return 1;
//             }
//         return -1;
        
                String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1);
        
        
            }
        
        
        
    
    
}