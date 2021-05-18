class Solution {
    
    class Task{
        int index;
        int start;
        int exec;
        public Task(int index , int start, int exec){
            this.index = index;
            this.start = start;
            this.exec = exec;
        }
    }
    public int[] getOrder(int[][] tasks) {
        
        PriorityQueue<Task> incomingQ = new PriorityQueue<>((Task a , Task b) -> a.start-b.start);
        
        for(int i = 0 ; i<tasks.length;i++){
            Task t = new Task(i ,tasks[i][0], tasks[i][1]);
            incomingQ.add(t);
        }
        
        // Processing Queue
        PriorityQueue<Task> processingQ = new PriorityQueue<>((Task a , Task b) -> (a.exec == b.exec) ? a.index - b.index : a.exec - b.exec);
        
        int timer = 0; // starting timer 
        List<Integer> res = new ArrayList<Integer>();
        
        while(!incomingQ.isEmpty() || !processingQ.isEmpty()){
            

            
            while(!incomingQ.isEmpty() && timer >= incomingQ.peek().start){ // adding tasks based on timer
                processingQ.add(incomingQ.poll());
            }
            
            if(processingQ.isEmpty()){
                timer = incomingQ.peek().start;
                continue;
            }
            
            timer += processingQ.peek().exec ; // adding timer
            res.add(processingQ.poll().index);
            
            
        }
        
        int[] ans = new int[res.size()];
        for(int i =0 ; i<res.size(); i++)
            ans[i] = res.get(i);
        
        return ans;
    }   
}