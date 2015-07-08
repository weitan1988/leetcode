public class MediaOfTwoSortedArrays {
    public double findMedianSortedArrays_solution1(int[] nums1, int[] nums2) {
        // merge sort, brute force, time complexity is O(m + n),
        // which m stands for the length of array nums1, and n stands for array nums2

        int m = nums1.length, n = nums2.length;
        int[] mergedArray = new int[m + n];
        int median_range = 0;
        if ((m + n) % 2 == 1) {
            // odd
            median_range = (m + n + 1) / 2;
        } else {
            median_range = (m + n) / 2;
        }
        int i = 0, j = 0, k = 0;
        while (i < nums1.length || j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                mergedArray[k] = nums1[i];
                i++, k++;
            } else if (nums1[i] > nums2[j]) {
                mergedArray[k] = nums2[j]
                j++, k++;
            } else {
                mergedArray[k] = nums1[i];
                i++, j++, k++;
            }
            if (k == median_range) {
                break;
            }
        }
        if ((m + n) % 2 == 1) return (double) (mergedArray[median_range] + mergedArray[median_range - 1]) / 2;
        else return (double) mergedArray[median_range];


    }

    public double findMedianSortedArrays_solution2(int[] nums1, int[] nums2) {
        // Time complexity is required as O(log(m+n)), means using divide and conquer
        /**
         * 1) Calculate the medians m1 and m2 of the input arrays nums1[] and nums2[] respectively.
         * 2) if(m1 == m2), done.
         * 3) if(m1 > m2), means that median is present in one of the below two subarrays.
         *      a) nums1(m1, m);
         *      b) nums2(0, m2);
         * 4) if(m1 < m2), then median is present in one of the below arrays
         *      a) nums1(0, m1);
         *      b) nums2(m2, n);
         * 5) Repeat the above process until the size of both the subarrays become 2
         * 6) If the size of the two arrays is 2 then use below formula to get the median
         *      Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
         */


    }

    public double getMedian(int A[], int B[], int k,
                            int aStart, int aEnd, int bStart, int bEnd)


}