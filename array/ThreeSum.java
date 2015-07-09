import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    /**
     * @param nums
     * @return Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     * Note:
     * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
     * The solution set must not contain duplicate triplets.
     * For example, given array S = {-1 0 1 2 -1 -4},
     * A solution set is:
     * (-1, 0, 1)
     * (-1, -1, 2)
     * Time Complexity: O(n^2)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        public ArrayList<ArrayList<Integer>> threeSum ( int[] num){
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            if (num.length == 0) return res;
            Arrays.sort(num);
            Set<ArrayList<Integer>> resSet = new HashSet<ArrayList<Integer>>();
            for (int i = 0; i < num.length; i++) {
                int j = i + 1;
                int k = num.length - 1;
                while (j < k) {
                    int sum_two = num[i] + num[j];
                    if (sum_two + num[k] < 0) j++;
                    else if (sum_two + num[k] > 0) k--;
                    else {
                        //find one triplet
                        ArrayList<Integer> triplet = new ArrayList<Integer>();
                        triplet.add(0, num[i]);
                        triplet.add(1, num[j]);
                        triplet.add(2, num[k]);
                        resSet.add(triplet);
                        j++;
                        k--;
                    }
                }
            }
            res.addAll(resSet);
            return res;
        }
    }
}