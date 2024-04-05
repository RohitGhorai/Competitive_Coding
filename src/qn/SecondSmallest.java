package qn;

public class SecondSmallest {
    public static void main(String[] args) {
        int[] nums = {20,4,10,50,30,50};
        int ans = secondSmallest(nums);
        System.out.println(ans);
    }
    static int secondSmallest(int[] nums){
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int num : nums){
            if (min > num){
                secondMin = min;
                min = num;
            }
            if (secondMin > num && num != min){
                secondMin = num;
            }
        }
        return secondMin;
    }
}
