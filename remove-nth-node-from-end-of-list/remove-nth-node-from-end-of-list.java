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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;
        if(head.next == null && n ==1)
            return null;
        int len = 0;
        ListNode p = head;
        while(p!= null){
            len++;
            p = p.next;
        }
        
        //System.out.println(len + "len -n " + (len-n));
        if(len - n == 0)
            return head.next;
     
        p = head; 
        for(int i = 1; i<  len - n; i++)
            p = p.next;
     
        p.next = p.next.next;
        
        return head;
        
    }
}