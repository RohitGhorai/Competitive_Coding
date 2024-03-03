package leetcode.array;

/*
CONTAINER WITH MOST WATER ----
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.

Notice that you may not slant the container.
 */
public class Problem_11 {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        int ans = maxArea(arr);
        System.out.println(ans);
    }
    static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int area = 0;
        while (left < right){
            int h = Math.min(height[left], height[right]);
            area = Math.max(area, h*(right-left));
            while (left < right && height[left] <= h) left++;
            while (left < right && height[right] <= h) right--;
        }
        return area;
    }
}
