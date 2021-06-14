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
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null)
            return head;
        
        ListNode slow = head , fast = head , prev = null;
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        return merge(l1 , l2);
    }
    
    
    public ListNode merge(ListNode p , ListNode q){
        
        ListNode resHead = new ListNode(0) , curr = resHead;
        
        while(p != null && q != null){
            
            if(p.val < q.val){
                
                curr.next = p;
                p = p.next;

            }
            else{

                curr.next = q;
                q = q.next;
            }
            
            curr = curr.next;
        }
        
        if(p != null)
            curr.next = p;
        if(q!= null)
            curr.next = q;
        
        return resHead.next;
    }
}