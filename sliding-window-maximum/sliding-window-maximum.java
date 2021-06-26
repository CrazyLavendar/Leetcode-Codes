class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        
        
        List<Integer> res = new ArrayList<>();
        
        Deque<Integer> dq = new ArrayDeque<>();     
        
        for(int i = 0 ; i< nums.length ; i++){
            
            while(!dq.isEmpty() && dq.peek() < i - k + 1)
                dq.poll();
            
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();
            
           
            dq.offer(i);
            // System.out.println(dq);
            
            if(i >= k -1)
            res.add(nums[dq.peek()]);
            
            
        }
        
        return res.stream().mapToInt(i->i).toArray();
    }
}