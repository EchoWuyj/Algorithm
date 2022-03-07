package com.wyj.algorithm.test.binary_search;

/**
 * @Author Wuyj
 * @DateTime 2022-03-01 19:47
 * @Version 1.0
 */
public class BinarySearch {
    public int binarySearch(int[] nums, int key) {
        int low = 0;
        int high = nums.length - 1;

        if (key > nums[high] || key < nums[low]) {
            return -1;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < key) {
                low = mid + 1;
            } else if (nums[mid] > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int binarySearch02(int[] nums, int key, int fromIndex, int toIndex) {
        if (key < nums[fromIndex] || key > nums[toIndex] || fromIndex > toIndex) {
            return -1;
        }

        int mid = (fromIndex + toIndex) / 2;

        if (nums[mid] > key) {
            return binarySearch02(nums, key, fromIndex, mid - 1);
        } else if (nums[mid] < key) {
            return binarySearch02(nums, key, mid + 1, toIndex);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int key = 4;
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.binarySearch02(arr, key, 0, arr.length - 1);
        System.out.println(result);
    }
}
