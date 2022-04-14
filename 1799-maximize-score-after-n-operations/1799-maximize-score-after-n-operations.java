class Solution {
   /*
  Idea:
  - DP(top down) + cache the result by representing the status with bit mask + recursion + backtracking
  Note:
    << has lower priority than +
	Runtime O(n^3) time. Eache recursion is N^2,N=2n recursion depth is n. Without take cache into account.
  */

  public static int maxScore(int[] nums) {
    return backtracking(1, nums, 0, new int[1 << nums.length]);
  }

  /*
  t: without it, no way to know which time current is to receive the score.
  status: with it to represent current status.
  cache: with it to keep current status's max score, avoid duplicate calculation.
  */
  private static int backtracking(int t, int[] nums, int status, int cache[]) {
    if (t == nums.length / 2 + 1) { // or status == (int) Math.pow(2d, nums.length * 1d) - 1
      return 0;
    }
    if (cache[status] == 0) {
      int ans = 0;
      for (int i = 0; i < nums.length; i++) {
        if (0 != (status & 1 << i)) continue;
        for (int j = i + 1; j < nums.length; j++) {
          if (0 != (status & (1 << j))) continue;
          ans =
              Math.max(
                  ans,
                  t * gcd(nums[i], nums[j])
                      + backtracking(t + 1, nums, status + (1 << j) + (1 << i), cache));
        }
      }
      cache[status] = ans;
    }
    return cache[status];
  }

  private static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}