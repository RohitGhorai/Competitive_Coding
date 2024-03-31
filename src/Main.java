import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        String s = "FThusvhusdc YVUdcsdgjdsi SDgy";
//        method(s);

//        int[] arr = {8, 8, 2, 4, 5, 5, 1};
//        int ans = trappingWater(arr, arr.length);
//        System.out.println(ans);

//        int[][] arr = {
//                {7, 6, 7, 6, 5, 4, 6, 6},
//                {5, 2, 5, 4, 8, 8, 8, 7},
//                {4, 5, 3, 5, 3, 4, 7, 4},
//                {4, 7, 6, 5, 7, 8, 6, 7},
//                {6, 7, 7, 6, 4, 8, 4, 7},
//                {5, 6, 8, 2, 2, 4, 3, 3},
//                {4, 4, 8, 2, 7, 7, 3, 3},
//                {7, 2, 5, 6, 7, 6, 2, 3}
//        };
//        List<Integer> ans = diagonalMatrix(arr);
//        System.out.println(ans);

        int[][] arr = {
                {1,  2,  3,  4},
                {10, 11, 12, 5},
                {9,  8,  7,  6},
        };

        List<Integer> list = spiralMatrix(arr);
        System.out.println(list);
    }

    static List<Integer> spiralMatrix(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int rmin = 0, rmax = arr.length - 1;
        int cmin = 0, cmax = arr[0].length - 1;
        while (count < n*m) {
            // top boundary
            int col = cmin;
            while (col <= cmax && count < m*n){
                list.add(arr[rmin][col]);
                col++;
                count++;
            }
            // right boundary
            rmin++;
            int row = rmin;
            while (row <= rmax && count < m*n){
                list.add(arr[row][cmax]);
                row++;
                count++;
            }
            cmax--;
            // bottom boundary
            col = cmax;
            while (col >= cmin && count < m*n){
                list.add(arr[rmax][col]);
                col--;
                count++;
            }
            rmax--;
            // left boundary
            row = rmax;
            while (row >= rmin && count < m*n){
                list.add(arr[row][cmin]);
                row--;
                count++;
            }
            cmin++;
        }
        return list;
    }
    static void method(String s){
        int n = s.length();
        int words = 0;
        int c = 0;
        for (int i = 0; i < n; i++){
            if (Character.isAlphabetic(s.charAt(i))) words++;
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                c++;
            }
        }
        int p = (c * 100)/words;
        System.out.println(p);
    }

    static int trappingWater(int[] arr, int n){
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        rightMax[n-1] = arr[n-1];
        for (int i = n - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        int count = 0;
        for (int i = 1; i < n - 1; i++){
            count += Math.min(rightMax[i], leftMax[i]) - arr[i];
        }
        return count;
    }

    static List<Integer> diagonalMatrix(int[][] arr){
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++){
            if (i % 2 == 0){
                int row = i, col = 0;
                while (row >= 0){
                    list.add(arr[row][col]);
                    row--;
                    col++;
                }
            } else {
                int row = 0, col = i;
                while (col >= 0){
                    list.add(arr[row][col]);
                    col--;
                    row++;
                }
            }
        }
        for (int i = 1; i < n; i++){
            if (n % 2 == 1){
                if (i % 2 == 0){
                    int row = n - 1, col = i;
                    while (col <= n-1){
                        list.add(arr[row][col]);
                        row--;
                        col++;
                    }
                } else {
                    int col = n - 1, row = i;
                    while (row <= n-1){
                        list.add(arr[row][col]);
                        col--;
                        row++;
                    }
                }
            } else {
                if (i % 2 == 1){
                    int row = n - 1, col = i;
                    while (col <= n-1){
                        list.add(arr[row][col]);
                        row--;
                        col++;
                    }
                } else {
                    int col = n - 1, row = i;
                    while (row <= n-1){
                        list.add(arr[row][col]);
                        col--;
                        row++;
                    }
                }
            }
        }

        return list;
    }
}
