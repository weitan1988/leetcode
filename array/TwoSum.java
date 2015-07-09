import java.lang.Integer;
import java.util.HashMap;

public class TwoSum {
    /**
     * @param nums
     * @param target
     * @return Given an array of integers, find two numbers such that they add up to a specific target number.
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
     * Please note that your returned answers (both index1 and index2) are not zero-based.
     * You may assume that each input would have exactly one solution.
     * Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
     */
    public int[] twoSum(int[] nums, int target) {
        // Time Complexity is O(n), n stands for the length of the array.
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                // find the pair
                res[0] = map.get(target - nums[i]) + 1;
                res[1] = i + 1;
            } else {
                /* put current number in the map, for example:
                   for numbers[1, 2, 14, 15, 7] looking for target = 3
                   first we have 1=0 in the map, then next time we met "2", we find the solution
                */
                map.put(nums[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}