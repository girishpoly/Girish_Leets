/*
Time Complexity for this solution is O(n)
Space Complexity is O(1)
*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
		/**
		* The first rule is if k = 1 we don't need to swap anything. 
		* That is because the only way is to swap with itself that doesn't make any sense
		*/
        if (k == 1) return head;
		
		/**
		* That is my favourite technique to have the top handler of LinkedList. 
		* It prevents from accidentally losing or damaging the head node somewhere in our code
		*/
        ListNode root = new ListNode(-1);
        root.next = head;

		/**
		* That approach helps us to know beforehand how many groups are available for reversing. 
		* e.g if head = 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 and k = 3 we will know that only 1 -> 2 -> 3 
		* and 4 -> 5 -> 6 are groups that need to be swapped and not to touch 7 -> 8
		*/
        int count = countNodes(head);
        int reverseCount = count / k;
        ListNode node = root;
        while (reverseCount > 0) {
            node = reverse(node, k);
            reverseCount--;
        }

        return root.next;
    }

	/*
	* The main job is in that method. Basically what we are doing here is to reverse the LinkedList in a particular range.  
	* That method takes the handler of the current potential group and returns the new handler for the next group for a further iteration.
	* e.g if we are given head = 1 -> 2 -> 3 -> 4 -> 5 and k = 2 as I mentioned earlier I add root handler(value = -1) to the head like this: 
	* root => -1 ->  | 1 -> 2 | -> 3 -> 4 -> 5. 
	* So the method will take reference of -1 at first, then reverses 1 and 2 like this 
	* root = -1 -> | 2 -> 1 | -> 3 -> 4 -> 5 and returns the reference of next potential group node = 1 -> | 3 -> 4 | -> 5. 
	* On the second iteration the method does the same. it reverses 3 and 4 like this 1 -> | 4 -> 3 | -> 5 and 
	* returns the reference of next potential group node = 3 -> | 5 . . . |
	* And this process goes again and again
	*/
    public ListNode reverse(ListNode node, int k) {
        ListNode curr = node.next;
        ListNode tail = null;
        ListNode reversed = null;

        while (k > 0 && curr != null) {
            ListNode newNode = curr.next;
            curr.next = reversed;
            reversed = curr;
            curr = newNode;
            if (reversed.next == null) tail = reversed;

            k--;
        }

        tail.next = curr;
        node.next = reversed;

        return tail;
    }

    public int countNodes(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }

        return count;
    }
}