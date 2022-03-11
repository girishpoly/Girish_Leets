	class Solution {
				public int maxProduct(int[] nums) {
				int max = nums[0] , curMax = nums[0] ,curMin = nums[0] , temp,i;
				for(i=1;i<nums.length;i++)
				{
					temp =curMax;
					curMax = Math.max(nums[i] , Math.max(nums[i]*curMax , nums[i]*curMin));
					curMin = Math.min(nums[i] , Math.min(nums[i]*temp , nums[i]*curMin));

					max = Math.max(max , curMax);
				}

				return max;
				}
			}