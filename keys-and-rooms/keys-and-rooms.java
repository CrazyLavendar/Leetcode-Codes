class Solution {
    int[] key;
    List<List<Integer>> rooms;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.rooms = rooms;
        key = new int[rooms.size()];
        this.key = key;
        key[0]=1;
        unlock(rooms.get(0));
        for(int i =0 ; i< key.length ; i++){
            if(key[i] == 0)
                return false;
        }
        return true;
    }
    public void unlock(List<Integer> room ){
        
        for(int i =0 ; i < room.size() ;i++){
            if(key[room.get(i)] != 1 ) {
                key[room.get(i)] =1;
                unlock(rooms.get(room.get(i))) ;
            }

        }
    }
    
    
}