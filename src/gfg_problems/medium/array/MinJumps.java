package gfg_problems.medium.array;

public class MinJumps {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int ans = minJumps(arr);
        System.out.println(ans);
    }

    static int minJumps_2(int[] arr){
        int jumpCount = 0;
        int maxReachable = 0;
        int current = 0;

        for(int i=0; i<arr.length; i++){
            maxReachable = Math.max(maxReachable, i + arr[i]);
            if(current == i){
                if(i != arr.length-1) jumpCount++;
                current = maxReachable;
            }
        }

        if(current < arr.length-1)
            return -1;
        return jumpCount;
    }
    static int minJumps(int[] arr){
        int n = arr.length;
        if (n <= 1) return 0;
        if (arr[0] == 0) return -1;
        int maxReach = arr[0];
        int steps = arr[0];
        int jumps = 1;
        for (int i = 1; i < n; i++) {
            if (i == n - 1) return jumps;
            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;
            if (steps == 0) {
                jumps++;
                if (i >= maxReach) return -1;
                steps = maxReach - i;
            }
        }

        return -1;
    }
}
