/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        HashSet<ListNode> set = new HashSet<>();
        
        ListNode curr = headA;
        
        while(curr != null){
            
            if(!set.contains(curr)){
                set.add(curr);
            }
            
            curr = curr.next;
            
        }
        
        ListNode currB = headB;
        
        while(currB != null){
            
            if(set.contains(currB)){
                return currB;
            }
            currB = currB.next;
        }
        
        return null;
    }
}