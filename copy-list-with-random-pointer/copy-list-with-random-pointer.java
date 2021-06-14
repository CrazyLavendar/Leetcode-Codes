/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        
        Map<Node , Node> map = new HashMap<>(); 
        
        Node curr = head , copyStart = new Node(-1) , copyPrev = copyStart;
        
        while(curr != null){
            Node copyCurr = new Node(curr.val);
            map.put(curr , copyCurr); //  for assigning Random use
            copyPrev.next = copyCurr;
            curr = curr.next;
            copyPrev = copyCurr;
        }
        
        curr = head;
        Node copyCurr = copyStart.next;
        
        while(curr != null){
            copyCurr.random = map.get(curr.random);
            copyCurr = copyCurr.next;
            curr = curr.next;
        }
        
        
        
        return copyStart.next;
    }
}