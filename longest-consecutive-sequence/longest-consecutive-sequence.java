class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashMap<Integer , Integer> map = new HashMap<>();
        int res = 0;
        for(int x : nums){
            if(!map.containsKey(x)){
                int sum = 1;
                int left = map.containsKey(x-1)? map.get(x-1) : 0;
                int right = map.containsKey(x+1)? map.get(x+1) : 0;
                sum += left + right;
                map.put(x  ,sum);
                map.put(x - left , sum);
                map.put(x + right , sum);
                res = Math.max(res , sum);
            }
        }
        return res;
    }
}