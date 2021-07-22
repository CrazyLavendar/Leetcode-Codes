class Coor{
    int x , y;
    public Coor(int x ,int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int m , n;
    int[][] dirs = new int[][]{{1,0} ,{0 ,1 }  , {-1,0 }  , {0,-1} };
    public int orangesRotting(int[][] grid) {
        
        Queue<Coor> fresh = new LinkedList<>();
        
        m = grid.length; n = grid[0].length;
        
        for(int i =0; i< m ; i++){
            for(int j =0; j< n ; j++){
                if(grid[i][j] == 1){
                    fresh.add(new Coor(i,j));
                }
            }
        }
         Queue<Coor> newFresh = new LinkedList<>();
         Queue<Coor> rotten = new LinkedList<>();
        
        
        int time =0 ;
        while(true){
        
        while(!fresh.isEmpty()){
            Coor curr = fresh.poll();
            if(isRot(grid , curr)){
                rotten.add(curr);
            }
            else
                newFresh.add(curr);
        }
            
        if(rotten.size() == 0 && newFresh.size() == 0)
            break;
        else if(rotten.size() == 0)
            return -1;
        
        while(!rotten.isEmpty()){
            Coor curr = rotten.poll();
            grid[curr.x][curr.y] = 2;
        }


        fresh = new LinkedList<>(newFresh);  
        newFresh.clear();
        time++;
       
    } 
        
        return time;
    }
    
    public boolean isRot(int[][] grid , Coor curr){
        for(int dir[] : dirs){
            int x = curr.x + dir[0] , y = curr.y + dir[1];
            if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0){
                continue;
            }
            else if(grid[x][y] >= 2){
                return true;
            }
        }
        

        return false;        
        
    }
    
}