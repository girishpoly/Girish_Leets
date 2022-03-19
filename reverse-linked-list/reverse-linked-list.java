/*
Set the head to a current node
Keep moving the current node while changing the head with every run
*/
public class Solution {
public ListNode reverseList(ListNode head) {

     if (head == null)
         return null;
      
     if(head.next == null)
         return head;
         
     ListNode current = head;
     
     while (current.next != null){
         //get the next node
         ListNode temp = current.next;

         //take the next node out of the chain and set current's next node to its next node
         current.next = temp.next;

         //now make the node we took out to point to head  
         temp.next = head;

         //reassign the head
         head = temp;
     }
     
     return head;
         
 }
}