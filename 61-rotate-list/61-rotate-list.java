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
  public ListNode rotateRight(ListNode head, int k) {

    if(head == null || head.next == null || k == 0) return head;
    
    ListNode curr = head;
    int length = 1;
    
	// calculate the length of the LinkedList//
    while(curr.next != null) {
        curr = curr.next;
        length++;
    }
    
    curr.next = head;
	// if the value of k is greater than length , we dont have to calculate that many times because if k = 5 we will end up having the same LinkedList// 
	//So to avoid that just modulo k with length//
	k = k % length;
    k = length - k;
    while(k-->0) {
        curr = curr.next;
    }
	// head->4->5 //
    head = curr.next;
	// 1->2->3-> null //
    curr.next = null;
    
	// head->4->5->1->2->3->null //
    return head;
}
}