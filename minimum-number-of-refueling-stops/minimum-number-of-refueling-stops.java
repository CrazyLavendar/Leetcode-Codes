class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        PriorityQueue<int[]> pq = new  PriorityQueue<>((int[] a, int[] b) -> b[1] - a[1]);
        Arrays.sort(stations , ((a , b) -> a[0] - b[0]));

        int d = startFuel , res = 0;
        
        int i =0;
        while(d < target){
            
            while(i < stations.length && d >= stations[i][0])
                pq.add(stations[i++]);
            
            if(pq.size() == 0 || pq.peek()[0] > d)
                return -1;
            else{
                res++;
                d += pq.poll()[1];
                
            }
            
        }
    
                                                       
                                                       
        return res;
    }
}