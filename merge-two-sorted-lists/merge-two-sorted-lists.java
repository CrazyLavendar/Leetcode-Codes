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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(-1 , l1);
        l1 = dummy;
        ListNode prev = dummy , p = l1.next , q = l2 , temp = null;
        
        while(p != null && q !=  null){
            if(q.val <= p.val){
                temp = q;
                q = q.next;
                temp.next = prev.next;
                prev.next = temp;
                prev = temp;
            }else{
                
                prev = p;
                p = p.next;
            }
        }
        
        if(p == null)
            prev.next = q;
        
        return l1.next;
    }
}