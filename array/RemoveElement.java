public class RemoveElement {
    /**
     * @param nums
     * @param val
     * @return Given an array and a value, remove all instances of that value in place and return the new length.
     * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     */
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        for(int i = 0; i < len; ){
            if(nums[i] == val)
                nums[i] = nums[--len];
            else
                i++;
        }
        return len;
    }
}