package com.wyj.algorithm.test.binary_search;

import com.sun.org.apache.regexp.internal.RE;
import sun.applet.Main;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author Wuyj
 * @DateTime 2022-03-07 17:10
 * @Version 1.0
 */
public class FindDuplicatedNumber {
    //HashMap
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return num;
            } else {
                map.put(num, 1);
            }
        }
        return -1;
    }

    //HashSet
    public int findDuplicate01(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }

    //二分查找
    public int findDuplicate02(int[] nums) {
        int left = 1;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }

            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }

            //左右指针重合时，找到target
            if (left == right) {
                return left;
            }
        }
        return -1;
    }

    //
    public int findDuplicate03(int[] nums) {
        return -1;
    }

    public static void main(String[] args) {
        int[] num01 = {1, 3, 4, 2, 2};
        int[] num02 = {1, 1};
        //int num02 = {2,2} 本身数组就不符合题目要求
        FindDuplicatedNumber findDuplicatedNumber = new FindDuplicatedNumber();
        System.out.println(findDuplicatedNumber.findDuplicate02(num02));
    }
}
