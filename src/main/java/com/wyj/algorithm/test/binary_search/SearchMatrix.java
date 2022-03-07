package com.wyj.algorithm.test.binary_search;

/**
 * @Author Wuyj
 * @DateTime 2022-03-03 19:20
 * @Version 1.0
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        //考虑问题需要全面
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;

        //二分查找
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            //计算中间位置
            int mid = (left + right) / 2;
            int midElement = matrix[mid / n][mid % n];
            if (midElement < target) {
                left = mid + 1;
            } else if (midElement > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,50}};
        int target = 34;
        SearchMatrix searchMatrix = new SearchMatrix();

        System.out.println(searchMatrix.searchMatrix(matrix, target));
    }
}
