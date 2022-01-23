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
        
        ListNode dummy = new ListNode(0);
        
        dummy.next = head;
        
        int len = 0 ;
        
        ListNode curr = head;
        
        while(curr != null){
            
            len++;
            curr = curr.next;
            
        }
        
        len = len - n ;
        
        curr = dummy;
        
        while(len > 0){
            
            len--;
            curr = curr.next;
            
        }
        
        curr.next = curr.next.next;
        return dummy.next;
        
    }
}