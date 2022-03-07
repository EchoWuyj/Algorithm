package com.wyj.algorithm.test.arrays;

/**
 * @Author Wuyj
 * @DateTime 2022-03-01 19:48
 * @Version 1.0
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        //转置矩阵
        int n = matrix.length;
        //遍历上半三角元素
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //翻转每一行
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    public void rotate01(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2 + n % 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                //准备工作
                int[] temp = new int[4];
                int row = i;
                int col = j;

                for (int k = 0; k < temp.length; k++) {
                    temp[k] = matrix[row][col];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }

                for (int k = 0; k < 4; k++) {
                    //构成一个循环队列
                    matrix[row][col] = temp[(k + 3) % 4];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
            }
        }
    }

    public void rotate02(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] image01 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        RotateImage rotateImage = new RotateImage();
        printImage(image);
        rotateImage.rotate02(image);
        System.out.println();
        printImage(image);

        System.out.println();

        rotateImage.rotate02(image01);
        printImage(image01);
    }

    public static void printImage(int[][] image) {
        for (int[] line : image) {
            for (int element : line) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }
}
