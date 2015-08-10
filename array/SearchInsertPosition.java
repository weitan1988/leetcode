public class Solution {
    /**
     * @param nums
     * @param target
     * @return Given a sorted array and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * You may assume no duplicates in the array.
     * Here are few examples.
     * [1,3,5,6], 5 → 2
     * [1,3,5,6], 2 → 1
     * [1,3,5,6], 7 → 4
     * [1,3,5,6], 0 → 0
     * Time Complexity: O(logN)
     */
    public int searchInsert(int[] nums, int target) {
        int L = 0, R = nums.length - 1;
        while(L <= R) {
            int M = L + (R - L) / 2;
            if(nums[M] == target)
                return M;
            else if(nums[M] < target)
                L = M + 1;
            else
                R = M - 1;
        }
        if(nums[M] < target)
            return M + 1;
        return M;
    }
}