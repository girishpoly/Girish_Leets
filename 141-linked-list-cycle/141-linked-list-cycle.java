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
    public boolean hasCycle(ListNode head) {
        
  ListNode fast = head;
        ListNode slow = head;
        
// now fast can't be null as it means LL is empty but also fast.next/slow.next can't be null as it means there is no cycle
       
        while(fast!=null && fast.next !=null){
            fast=fast.next.next;
            slow=slow.next;
            
            if(fast==slow){
                return true;
            }
        }
        return false;
        
    }
}