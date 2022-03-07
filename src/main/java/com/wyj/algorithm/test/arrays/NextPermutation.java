package com.wyj.algorithm.test.arrays;

/**
 * @Author Wuyj
 * @DateTime 2022-02-28 19:35
 * @Version 1.0
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        //从倒数第二数开始比较
        int k = n - 2;

        while (k >= 0 && nums[k] >= nums[k + 1]) {
            k--;
        }
        //返回的k就是确定的索引下表

        if (k == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        int i = k + 2;
        while (i < n && nums[i] > nums[k]) {
            i++;
        }
        swap(nums, k, i - 1);

        int start = k + 1;
        int end = n - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    //交换元素的代码
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);

        for (int num : nums) {
            System.out.print(num + "\t");
        }
    }
}
