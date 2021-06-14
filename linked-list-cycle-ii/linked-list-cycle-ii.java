/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null  || head.next == null)
            return null;
    
        
        
        ListNode slow = head , fast = head.next;
        while(fast != null && fast.next != null){
            
            if(slow == fast){
                break;
            }
            
            slow = slow.next;
            fast = fast.next.next;   
        }
        
        if(fast == null || fast.next == null)
            return null;
        
        ListNode p = head , q = slow , curr = q.next;
        
        if(p == q)
            return p;
        
        
        while(p!=slow){
            while(curr != q){
                if(p == curr)
                    return p;
                
                curr = curr.next;
            }
            p = p.next;
            curr = q.next;
        }
        
        
        
        return p;
        
    }
}