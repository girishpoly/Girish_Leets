/*
Start with one letter and two letter strings and expand on both sides.
These are the smallest substrings which can be checked with simple first and last char check and then further checks are built on top of them. 
When you start with single letter strings, the build up for odd length strings and
when you start with two lettered strings they build up for even length strings. 
These are the first and second countSubstrings function calls in the loop.
T/S: O(n²)/O(1). Time & Memory beats 100%, faster than DP and needs no extra space.
*/
class Solution {
    public int countSubstrings(String s) {
	int count = 0;
	for (int i = 0; i < s.length(); i++)
		count += countSubstrings(s, i, i) + countSubstrings(s, i, i + 1);
	return count;
}

private int countSubstrings(String s, int start, int end) {
	int count = 0;
	while (start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++)) 
		count++;
	return count;
}
}