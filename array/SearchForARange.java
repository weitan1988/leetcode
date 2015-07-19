public class SearchForARange {
    /**
     * @param nums
     * @param target
     * @return Given a sorted array of integers, find the starting and ending position of a given target value.
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * If the target is not found in the array, return [-1, -1].
     * For example,
     * Given [5, 7, 7, 8, 8, 10] and target value 8,
     * return [3, 4].
     * Solution: Binary Search
     * Time Complexity: O(logN)
     * Do two runs of binary search for the index of largest element strictly less than target, and the index of largest element strictly less than target+1.
     * The range is between this two indices.
     */

    public int[] searchRange(int[] nums, int target) {
        // find the leftmost match
        int L = 0, R = nums.length - 1;
        while (L < R) {
            int M = L + (R - L) / 2;
            if (nums[M] < target) L = M + 1;
            else R = M;
        }
        int start = L;
        if (nums[L] != target) return new int[]{-1, -1}; // no match is found
        // find the rightmost match
        R = nums.length - 1;
        while (L < R) {
            int M = L + (R - L) / 2;
            if (nums[M] > target) R = M;
            else L = M + 1;
        }
        int end = L;
        if (nums[L] != target) end = L - 1; // if no match on L, need to move backward a step
        return new int[]{start, end};
    }
}