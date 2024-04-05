package qn;

public class SecondLargest {
    public static void main(String[] args) {
        int[] nums = {20,4,10,50,30,50};
        int ans = secondLargest(nums);
        System.out.println(ans);
    }
    static int secondLargest(int[] nums){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int num : nums){
            if (max < num){
                secondMax = max;
                max = num;
            }
            if (secondMax < num && num != max) {
                secondMax = num;
            }
        }
        return secondMax;
    }
}
