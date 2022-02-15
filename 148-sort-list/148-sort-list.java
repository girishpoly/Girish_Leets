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
          if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = findMid(head);
        
        ListNode first = head;
        ListNode second = mid.next;
        mid.next = null;
        
        first = sortList(first);
        second = sortList(second);
        
        return merge(first, second);
    }
    
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode merge(ListNode first, ListNode second) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        
        while (first != null && second != null) {
            if (first.val < second.val) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }
        
        if (first != null) {
            current.next = first;
        }
        
        if (second != null) {
            current.next = second;
        }
        
        return dummy.next;
    }
}