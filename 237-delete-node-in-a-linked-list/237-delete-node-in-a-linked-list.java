/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
public void deleteNode(ListNode node) {
// Copy the value from the next node into the current one
// Then, skip to the next node
node.val = node.next.val;
node.next = node.next.next;
}
}