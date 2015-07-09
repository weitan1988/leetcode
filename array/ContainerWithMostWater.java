import java.lang.Math;

public class ContainerWithMostWater {
    /**
     * @param height
     * @return Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
     * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
     * Note: You may not slant the container.
     */
    public int maxArea(int[] height) {
        int res = 0;
        int leftMostIndex = 0, rightMostIndex = height.length - 1;
        while (leftMostIndex <= rightMostIndex) {
            int tmp = (rightMostIndex - leftMostIndex) * Math.min(height[leftMostIndex], height[rightMostIndex]);
            res = Math.max(res, tmp);
            if (height[leftMostIndex] < height[rightMostIndex])
                leftMostIndex++;
            else
                rightMostIndex--;
        }
        return res;
    }
}