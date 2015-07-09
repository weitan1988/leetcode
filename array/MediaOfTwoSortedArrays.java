public class MediaOfTwoSortedArrays {
    /**
     * @param nums1
     * @param nums2
     * @return There are two sorted arrays nums1 and nums2 of size m and n respectively.
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     */
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
        /**
         * Time complexity is required as O(log(m+n)), means using divide and conquer
         *
         * Algorithms:
         * 1) Calculate the medians m1 and m2 of the input arrays nums1[] and nums2[] respectively.
         * 2) if(m1 == m2), done.
         * 3) if(m1 > m2), means that median is present in one of the below two subarrays.
         *      a) From first element of ar1 to m1 (ar1[0...|_n/2_|])
         *      b) From m2 to last element of ar2 (ar2[|_n/2_|...n-1])
         * 4) if(m1 < m2), then median is present in one of the below arrays
         *      a) From m1 to last element of ar1 (ar1[|_n/2_|...n-1])
         *      b) From first element of ar2 to m2 (ar2[0...|_n/2_|])
         * 5) Repeat the above process until the size of both the subarrays become 2
         * 6) If the size of the two arrays is 2 then use below formula to get the median
         *      Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
         *
         * Notice for the corner cases:
         *
         */
        int m = nums1.length;
        int n = nums2.length;
        if ((m + n) % 2 != 0) // odd
            return (double) findKth(nums1, nums2, (m + n) / 2, 0, m - 1, 0, n - 1);
        else // even
            return (findKth(nums1, nums2, (m + n) / 2, 0, m - 1, 0, n - 1) + findKth(nums1, nums2, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;

    }

    public double findKth(int A[], int B[], int k,
                          int aStart, int aEnd, int bStart, int bEnd) {
        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;

        // Handle special cases
        if (aLen == 0)
            return B[bStart + k];
        if (bLen == 0)
            return A[aStart + k];
        if (k == 0)
            return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
        int aMid = aLen * k / (aLen + bLen); // a's middle count;
        int bMid = k - aMid - 1; // b's middle count

        // make aMid and bMid to be array index
        aMid = aMid + aStart;
        bMid = bMid + bStart;

        if (A[aMid] > B[bMid]) {
            k = k - (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        } else {
            k = k - (aMid - aStart + 1);
            bEnd = bMid;
            aStart = aMid + 1;
        }
        return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
    }


}