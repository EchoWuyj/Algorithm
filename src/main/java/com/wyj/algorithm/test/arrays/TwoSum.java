package com.wyj.algorithm.test.arrays;

import java.util.HashMap;

/**
 * @Author Wuyj
 * @DateTime 2022-02-28 14:44
 * @Version 1.0
 */
public class TwoSum {
    public int[] twoSum01(int[] nums, int target) {
        //暴力法
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("no solution");
    }

    //哈希表
    public int[] twoSum02(int[] nums, int target) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int thatNum = target - nums[i];
            if (map.containsKey(thatNum) && map.get(thatNum) != i) {
                return new int[]{i, map.get(thatNum)};
            }
        }
        throw new IllegalArgumentException("no solution");
    }

    public int[] twoSum03(int[] nums, int target) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int thatNum = target - nums[i];
            if (map.containsKey(thatNum)) {
                return new int[]{map.get(thatNum), i};
            }

            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no solution");
    }

    public static void main(String[] args) {
        //测试用例
        int[] input = {2, 7, 11, 15};
        int target = 9;

        int[] result = new TwoSum().twoSum02(input, target);
        for (int res : result) {
            System.out.print(res + "\t");
        }
    }
}
