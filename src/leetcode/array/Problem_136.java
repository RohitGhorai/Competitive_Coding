package leetcode.array;

public class Problem_136 {
    public static void main(String[] args) {
        int[] arr = {2,2,1};
        int ans = singleNumber(arr);
        System.out.println(ans);
        System.out.println(2^1);
    }
    static int singleNumber(int[] nums){
        int i = nums[0];
        for (int j = 1; j < nums.length; j++) i ^= nums[j];
        return i;
    }
}
