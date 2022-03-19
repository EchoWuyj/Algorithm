package com.wyj.algorithm.test.hashmap;

import javax.print.attribute.standard.MediaName;
import java.util.Currency;
import java.util.HashSet;

/**
 * @Author Wuyj
 * @DateTime 2022-03-19 14:29
 * @Version 1.0
 */
public class LongestConsecutiveSequence {
    //暴力法
    public int longestConsecutiveSequence01(int[] nums) {
        //定义最大长度
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            int curLength = 1;

            while (contains(nums, curNum + 1)) {
                curNum++;
                curLength++;
            }
            maxLength = Math.max(maxLength, curLength);
        }
        return maxLength;
    }

    public boolean contains(int[] nums, int key) {
        for (int num : nums) {
            if (num == key) {
                return true;
            }
        }
        return false;
    }

    //HashMap改进
    public int longsetConsecutiveSequence02(int[] nums) {
        int maxLength = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            int curLength = 1;

            while (set.contains(curNum + 1)) {
                curLength++;
                curNum++;
            }
            maxLength = Math.max(curLength, maxLength);
        }
        return maxLength;
    }

    //
    public int longsetConsecutiveSequence03(int[] nums) {
        int maxLength = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            int curLength = 1;

            if (!set.contains(curNum - 1)) {
                while (set.contains(curNum + 1)) {
                    curLength++;
                    curNum++;
                }
                maxLength = Math.max(curLength, maxLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] num1 = {100, 4, 200, 1, 3, 2};
        int[] num2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        System.out.println(longestConsecutiveSequence.longsetConsecutiveSequence03(num1));
        System.out.println(longestConsecutiveSequence.longsetConsecutiveSequence03(num2));
    }
}
