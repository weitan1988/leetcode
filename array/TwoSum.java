import java.lang.Integer;
import java.util.HashMap;

public class TwoSum {
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