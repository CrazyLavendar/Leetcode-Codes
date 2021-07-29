/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        Map<Integer , ListNode> map= new HashMap<>();
        ListNode p = head; int n = 0;
        while(p!= null){
            
            map.put(n++ , p);
            p = p.next;
        }
        // System.out.println(n);
        
        int left = 1, right = n-1;
        
        p = head;
        while(left <= right){

        p.next = map.get(right--);    
        
        p = p.next ;
        
        p.next = map.get(left++);
            
        p = p.next;
        }
        p.next = null;

    }
}