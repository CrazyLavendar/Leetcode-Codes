class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        
        if(nums1.length > nums2.length)
            intersect(nums2 ,nums1);
        
        
        HashMap<Integer , Integer> map = new HashMap<>();
        
        for(int x : nums1){
            if(!map.containsKey(x))
                map.put(x , 0);
            map.put(x , map.get(x) + 1);
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(int y  : nums2){
            
            if(map.containsKey(y)){
                res.add(y);
                map.put(y , map.get(y) - 1);
                if(map.get(y)== 0)
                    map.remove(y);
            }
            
        }
        
        return res.stream().mapToInt(in->in).toArray();
        
    }
}