class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        for(int stone : stones)
            pq.add(stone);
        
        while(pq.size() > 1){
            int curr = pq.poll() - pq.poll(); 
            if(curr>0)
                pq.add(curr);
        }
        
        return pq.size() == 1 ? pq.poll() : 0;
    }
}