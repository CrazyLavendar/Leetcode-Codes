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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode dummy  = new ListNode(-1 , head);
        // head = dummy;
        int i=0;
        ListNode p = dummy;
        while(i < left -1){
            p = p.next;
            i++;
        }
        
        ListNode q = p ;
        while(i < right + 1){
            q = q.next;
            i++;
        }
        
        // System.out.println(p.val + " " + q.val);
        
        ListNode reversed = reverse(p.next , q);
        
        p.next = reversed;
        
        return dummy.next;
        
    }
    
    public ListNode reverse(ListNode head , ListNode end){
        
        ListNode  start = head, curr = head.next;
        
        while(curr != end){
            
            
            head.next = curr.next;
            curr.next = start; 
            start = curr;
            
            curr = head.next;
            
        }
        
        return start;
    }
}