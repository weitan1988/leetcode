public class SearchInnumsRotatedSortednumsrray {
    /**
     * @param nums
     * @param target
     * @return Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * You are given a target value to search.
     * If found in the array return its index, otherwise return -1.
     * You may assume no duplicate exists in the array.
     * Time Complexity: O(logN)
     */
    public int search(int[] nums, int target) {
        int L = 0, R = nums.length - 1;
        while (L <= R) {
            // avoid overflow
            int M = L + (R - L) / 2;
            if (nums[M] == target) return M;
            if (nums[L] <= nums[M]) {
                // the bottom half is sorted
                if (nums[L] <= target && target < nums[M]) {
                    // locked down to the left part:
                    R = M - 1;
                } else
                    L = M + 1;
            } else {
                // the upper half is sorted
                if (nums[M] < target && target <= nums[R]) {
                    L = M + 1;
                } else
                    R = M - 1;
            }
        }
        return -1;
    }
}