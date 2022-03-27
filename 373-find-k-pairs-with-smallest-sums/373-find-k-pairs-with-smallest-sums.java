/*
https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/837123/Java-or-Two-solutions-using-Heap-or-Time%3A-O(klogk)-or-Optimal

This is a naive approach of solving this problem where you construct all pairs from the given arrays nums1 & num2 and pick top k having the smallest sums using a min heap. This approach will pass all the given test cases but performs slower in terms of execution time. [~20ms]

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<int[]> allPairs = new PriorityQueue<>((a, b) -> a[2] - b[2]);

		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				allPairs.add(new int[] { nums1[i], nums2[j], nums1[i] + nums2[j] });
			}
		}

		List<List<Integer>> kSmallestPairs = new ArrayList<>();

		while (!allPairs.isEmpty() && k-- > 0) {
			int[] currentPair = allPairs.poll();
			kSmallestPairs.add(Arrays.asList(currentPair[0], currentPair[1]));
		}

		return kSmallestPairs;
	}
Time: O((n1 * n2)log(n1 * n2) + klog(n1 * n2)) ~= O((n1 * n2)log(n1 * n2))
Space: O(n1 * n2)
where n1, n2 are the lengths of given arrays nums1, nums2 respectively.

Approach 2:

In approach 1, we haven't utilized the given property of the arrays nums1, nums2 where each array is sorted in an ascending order. Therefore, to make use of that property, we define a min heap (sorted by sum of nums1[i], nums2[j]) and add first k pairs into the heap.
Note that product of i * j combination pairs between  nums1 & nums2 will never exceed required k and this observation is the key to this aprroach. Index j pointing to nums2 array is initially 0 and we start to map min(n1, k) elements in nums1 array to zeroth index of nums2 array.

Time: O(klogk) as we only maintain k pairs in the heap any point in time and it takes logk time to swim up/down.


*/
class Solution {
     public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;

		List<List<Integer>> kSmallestPairs = new ArrayList<>();

        // No pairing possible when n1/n2/k == 0
		if (n1 == 0 || n2 == 0 || k == 0) {
			return kSmallestPairs;
		}

        // Sort by sum of nums1[i], nums2[j]
		PriorityQueue<int[]> smallestSumPairs = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        // Add min(n1, k) pairs to the heap where each element in nums1 array pairs up with 0th index in nums2 array initially!
        // Note that index 2 of each pair is the sum of nums1[i], nums2[0] which is used to heapify & thereby pick k smallest pairs
		for (int i = 0; i < Math.min(n1, k); i++) {
			smallestSumPairs.add(new int[] { nums1[i], 0, nums1[i] + nums2[0] });
		}

		while (!smallestSumPairs.isEmpty() && k-- > 0) {
			int[] currentPair = smallestSumPairs.poll();

			kSmallestPairs.add(Arrays.asList(currentPair[0], nums2[currentPair[1]]));

            // If currentPair[1] (aka 'j' referring to nums2 array) is within bounds? - Add 1 to the current index 'j' to get the next number in nums2 array
			if (currentPair[1] < n2 - 1) {
				smallestSumPairs.add(new int[] { currentPair[0], currentPair[1] + 1, currentPair[0] + nums2[currentPair[1] + 1] });
			}
		}

		return kSmallestPairs;
    }
}