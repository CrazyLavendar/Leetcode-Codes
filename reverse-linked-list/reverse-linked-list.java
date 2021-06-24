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
    public ListNode reverseList(ListNode head) {
        
        if(head == null || head.next == null)
            return head;
        ListNode start = head , curr = head.next;
        
        
        while(curr != null){
            
            head.next = curr.next;
            curr.next = start;
            start = curr;
            curr = head.next;
            
            
        }
        
        return start;
    }
}