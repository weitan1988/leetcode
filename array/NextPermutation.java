import java.util.Arrays;

public class NextPermutation {
    /**
     * @param nums
     */

    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
     * The replacement must be in-place, do not allocate extra memory.
     * Here are some examples.
     * Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     */

    /**
     * Solution:
     * Time Complexity: O(2N)
     * 1. From right to left, find the first digit(partition number) which violate the increase
     * 2. From right to left, find the first digit which larger than the partition number, call it the change number.
     * 3. Swap the partition number and the change number.
     * 4. Reverse all the digit on the right of partition index.
     */
    public void nextPermutation(int[] nums) {
        // record the index to be swapped
        int i1 = 0, i2 = 0, i = nums.length - 1;
        // skip the descending order
        while (i > 0 && nums[i - 1] >= nums[i]) i--;
        if (i == 0) {
            // Already sorted as a descending order, return the first
            Arrays.sort(nums);
            return;
        } else i1 = i - 1;
        // reset the i
        i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i1]) i--;
        i2 = i;
        // swap
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
        Arrays.sort(nums, i1 + 1, nums.length);
        return;

    }
}