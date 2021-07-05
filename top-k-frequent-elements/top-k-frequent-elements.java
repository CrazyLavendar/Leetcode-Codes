class Solution {
    public int[] topKFrequent(int[] nums, int k) {
//         List<Integer> res = new ArrayList<>();
//         Map<Integer , Integer> map = new HashMap<>();
//         for(int x : nums){
//             if(!map.containsKey(x))
//                 map.put(x , 0);
//             map.put(x , map.get(x) + 1);
//         }
        
//         List<List<Integer>> list = new ArrayList<>();
        
//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//         list.add(new ArrayList<>(List.of(entry.getKey() , entry.getValue())));
// }

//         Collections.sort(list , (a , b) -> b.get(1) - a.get(1));
        
//             for(int i = 0 ; i< k ; i++)
//                 res.add(list.get(i).get(0));
        
//         return res.stream().mapToInt(i -> i).toArray();
        
        
        Map<Integer , Integer> map = new HashMap<>();
        
        for(int x : nums){
         if(!map.containsKey(x))
            map.put(x,0);
            
        map.put(x , (map.get(x) + 1));
        }

        List<Integer>[] bucket = new List[nums.length +1];
        
        for(Integer key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(int i =nums.length ; i >=0 ; i--){
            
            
            if(bucket[i] != null){
                for(int x : bucket[i])
                    res.add(x);
            }
            
            if(res.size() >= k)
                break;
            
        }
        
        

        return res.stream().mapToInt(i -> i).toArray();

    }
}