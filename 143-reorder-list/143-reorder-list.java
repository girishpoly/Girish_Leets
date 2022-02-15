/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
  Intuition :
1) Push the node in stack so that we can fetch in reverse order.
2) Calculate half size of list.
3) Traverse till the size, take one node from list & one from stack
4) Assign null in stack's last node otherwise it will have the link to other nodes.
 */
class Solution {
    public void reorderList(ListNode head) {
         Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while(curr != null){
            stack.push(curr);
            curr = curr.next;
        }
        int size = (stack.size()-1)/2;
        curr = head;
        while(size-- > 0){
            ListNode top = stack.pop();
            ListNode temp = curr.next;
            curr.next = top;
            top.next = temp;
            curr = temp;
        }
        stack.pop().next = null;
    }
}