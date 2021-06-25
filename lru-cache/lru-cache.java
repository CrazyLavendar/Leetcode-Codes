// DLL Node
class Node{
    
    int key, value;
    Node prev , next;
    
    public Node(){
    }
    
    public Node(int key , int value){
        this.key = key;
        this.value = value;
        // this.prev = null;
        // this.next = null;
    }
    
    public Node(int key , int value , Node prev , Node next){
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
    
}

class LRUCache {
    HashMap<Integer , Node> map;
    int capacity;
    Node head, tail;

    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {

        if(!map.containsKey(key))
            return -1;
        Node curr = map.get(key);
        removeSelected(curr.key);
        insertHead(curr.key , curr.value);
        return head.next.value;
    }
    
    public void put(int key, int value) {
        
        
        if(map.containsKey(key)){
            removeSelected(key);
        }
        else if(map.size() == capacity){
            removeTail();
        }
        
        insertHead(key , value);
        
        // Node  p = tail.prev;
//         while(p != head){
//             System.out.print(p.value + " ");
//             p = p.prev;
//         }
//         System.out.println("");
        
//        p = head.next;
//         while(p != tail){
//             System.out.print(p.value + " ");
//             p = p.next;
//         }
//         System.out.println("");
        
    }
    public void removeSelected(int key){
       
        Node selected = map.get(key);
        selected.prev.next = selected.next;
        selected.next.prev = selected.prev;
        map.remove(key);
        
    }
    
    public void removeTail(){
        
        Node selected = tail.prev;
        selected.prev.next = selected.next;
        selected.next.prev = selected.prev;
        map.remove(selected.key);     
    }
    
    public void insertHead(int key , int value){

        Node newNode = new Node(key , value , head , head.next);

        head.next.prev = newNode;
        head.next = newNode;
              map.put(key , newNode);
    
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */