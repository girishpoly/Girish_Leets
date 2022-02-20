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
  ListNode slow = head, fast = head;
  
  while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    
    if (slow == fast)
        // found the cycle
        break;
  }
  
  if (fast == null || fast.next == null)
    // in case there is no cycle
    return null;
  
  // let the slow pointer go from the head 
  // and meet the fast pointer
  // the meeting point is our answer
  slow = head;
  
  while (slow != fast) {
    slow = slow.next;
    fast = fast.next;
  }
  
  return slow;
}
}