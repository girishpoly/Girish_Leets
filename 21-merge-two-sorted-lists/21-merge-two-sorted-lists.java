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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
         //Define a new Node
        ListNode result = new ListNode();
        ListNode curr = result;
        
        //If list1 has no element then add list2 to new node
        if (list1 == null)
           return curr.next = list2;
        
        //If list2 has no element then add list1 to new node
        if (list2 == null)
            return curr.next = list1;
        
        
        //Use Merge sort logic to merge nodes value
        while (list1 != null && list2 != null)
        {
            if (list1.val <= list2.val)
            {
                curr.next = list1;
                list1 = list1.next;
            }
            else 
            {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
    
        //If any node left in list1
        if (list1 != null)
            curr.next = list1;
     
        //If any node left in list2
        if (list2 != null)
            curr.next = list2;
        
        return result.next;
    }
}