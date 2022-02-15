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