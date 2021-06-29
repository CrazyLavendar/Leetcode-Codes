class Task{
    int num;
    int time;
    int count;
    public Task(int num , int time , int count){
        this.num = num;
        this.time = time;
        this.count = count;
    }
    
}

class Solution {
    int timer =1;
    public int leastInterval(char[] tasks, int n) {
    
    int[] taskArray = new int[26];
        
    for(char c : tasks){
        int t = c - 'A';
        taskArray[t]++;
    }
        
    PriorityQueue<Task> pq = new PriorityQueue<>( (a,b)-> a.count == b.count? a.num - b.num : b.count - a.count); // Scheduling Queue
    
    for(int i = 0 ; i< 26 ; i++){
        if(taskArray[i] == 0)
            continue;
        else{
            Task t = new Task(i , 0 , taskArray[i]);
            pq.add(t);
        }
    }
    
    Queue<Task> q = new LinkedList<>(); // Waiting Queue
    
    while(!pq.isEmpty() || !q.isEmpty()){
        
        while(!q.isEmpty() && timer >= q.peek().time){ // waiting queue to Scheduling queue
            pq.add(q.poll());
        }
        if(!pq.isEmpty()){
            Task t = pq.poll();
            t.count -= 1;
           // System.out.println(timer + " Task : " + t.num + " Balance:  "+ t.count + " nrxt time : "+ (timer + n +1));
            if(t.count > 0){
                t.time = timer +n+1; // cooldown
                
                q.add(t);
            }
        }
        timer++;
    }
        
    return timer-1;
    }
}