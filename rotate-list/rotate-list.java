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
    public ListNode rotateRight(ListNode head, int k) {
        
        int n = 0;
        ListNode p = head, last = null;
        while(p!= null){
            n++;
            last = p;
            p = p.next;
        }
        
        if(n<2)
            return head;
        
        k = k%n;
        int i = 1;
        p = head;
        while(i < n-k){
            p = p.next;
            i++;
            
        }
        
        // System.out.println(n + " " + k + " "+ i + " " +p.val);
        last.next = head;
        last = p;
        p = p.next;
        last.next = null;
        

        
        return p;
    }
}