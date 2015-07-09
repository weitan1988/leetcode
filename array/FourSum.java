public class FourSum {
    /**
     * @param nums
     * @param target
     * @return Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
     * Find all unique quadruplets in the array which gives the sum of target.
     * Note:
     * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
     * The solution set must not contain duplicate quadruplets.
     * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
     * A solution set is:
     * (-1,  0, 0, 1)
     * (-2, -1, 1, 2)
     * (-2,  0, 0, 2)
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < length - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j-1])  continue;
                int l = j + 1, r = length - 1;
                while(l < r) {
                    int delta = nums[i] + nums[j] + nums[l] + nums[r] - target;
                    if(delta == 0) {
                        // skip duplicates
                        if (l > j + 1 && nums[l] == nums[l - 1]) {
                            l++;
                            continue;
                        }
                        if(r < length - 1 && nums[r] == nums[r + 1]) {
                            r--;
                            continue;
                        }
                        ArrayList<Integer> item = new ArrayList<Integer>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[l]);
                        item.add(nums[r]);
                        res.add(item);
                        l++;
                        r--;
                    } else if(delta < 0)
                        l++;
                    else
                        r--;
                }
            }
        }
        return res;
    }
}