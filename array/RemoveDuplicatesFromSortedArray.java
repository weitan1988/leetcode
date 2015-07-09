public class RemoveDuplicatesFromSortedArray {
    /**
     * @param nums
     * @return Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     * For example,
     * Given input array nums = [1,1,2],
     * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
     * It doesn't matter what you leave beyond the new length.
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int i = 0;
        if(len <= 1) return len;
        for(int j = 1; j < len; j++) {
            // if the next element is not equaled to the previous one, move on to the next one, other wise, previous index doesn't change, cover it directly
            if(nums[j] != nums[i]) nums[++i] = nums[j];
        }
        return i + 1;
    }
}