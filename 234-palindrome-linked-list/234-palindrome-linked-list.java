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
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        ListNode curr = head;
        
        while(curr != null){
            arr.add(curr.val);
            curr = curr.next;
        }
        
        if(arr.size() == 0 || arr.size() == 1){
            return true;
        }
        
        int start = 0 ;
        int end = arr.size()-1;
        
        while(start < end){
            
            if(arr.get(start) == arr.get(end)){
                start++;
                end--;
            }
            else{
                return false;
            }
            
        }
        
        return true;
    }
}