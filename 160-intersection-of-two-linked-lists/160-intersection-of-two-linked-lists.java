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

  ListNode fast=headA;
    ListNode slow=headB;
    int c1=0;//length of list A
    int c2=0;//length of list B
    while(fast!=null){ //
        fast=fast.next;//counting length of list A
    c1++;              //
    }                  //
    
    while(slow!=null){
        slow=slow.next;//counting length of list 2
        c2++;
    }
    
    int max=Math.max(c1,c2);//which list length is big

    int gap=0;
    
    if(c1>c2){
    gap=c1-c2;
}else{                //gap betn two links
        gap=c2-c1;
    }
    
    
    
   fast=headA;  //reseting list to head/starting
     slow=headB;
    if(c1>c2){// if first list is big than head incremet so links length  will be same
        for(int i=0;i<gap;i++){ 
		
            fast=fast.next;
        }
        
    }else{
            for(int i=0;i<gap;i++){
                slow=slow.next;
            
        }
    }
    while(fast!=slow){
        fast=fast.next;//then incemnts both heads by same when both equals intersection node be found
        slow=slow.next;
    }
    return fast;
    
}
}