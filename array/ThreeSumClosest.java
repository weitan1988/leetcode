public class ThreeSumClosest {
    /**
     * @param nums
     * @param target
     * @return Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.
     * You may assume that each input would have exactly one solution.
     * For example, given array S = {-1 2 1 -4}, and target = 1.
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     * Time Complexity: O(n^2)
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3)
            return Integer.MAX_VALUE;
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int tmp = nums[i] + nums[j] + nums[k];
                if (tmp == target)
                    return target;
                else if (Math.abs(tmp - target) < Math.abs(res - target))
                    res = tmp;
                if (target < tmp)
                    k--;
                else
                    j++;
            }
        }
        return res;
    }
}