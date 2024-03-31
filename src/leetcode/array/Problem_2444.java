package leetcode.array;

/**
 *  https://leetcode.com/problems/count-subarrays-with-fixed-bounds/
 */
public class Problem_2444 {

    public static void main(String[] args) {
        int[] nums = {1,3,5,2,7,5};
        int minK = 1;
        int maxK = 5;
        long ans = countSubarrays(nums, minK, maxK);
        System.out.println(ans);
    }
    static long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int minI = -1;
        int maxI = -1;
        int lt = -1;
        for (int r = 0; r < nums.length; r++){
            if (minK > nums[r] || nums[r] > maxK){
                lt = r;
                minI = r;
                maxI = r;
            }
            minI = (minK == nums[r]) ? r : minI;
            maxI = (maxK == nums[r]) ? r : maxI;
            count += Math.min(maxI, minI) - lt;
        }
        return count;
    }
}