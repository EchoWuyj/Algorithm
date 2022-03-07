package com.wyj.algorithm.test.arrays;

import java.util.*;

/**
 * @Author Wuyj
 * @DateTime 2022-02-28 16:35
 * @Version 1.0
 */
public class ThreeSum {
    //暴力法
    public List<List<Integer>> threeSum01(int[] nums) {
        int n = nums.length;
        //定义结果列表
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        //将数组转成list
                        List<Integer> tempList = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(tempList);
                    }
                }
            }
        }
        return result;
    }

    //哈希map
    public List<List<Integer>> threeSum02(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int thatNum = 0 - nums[i];
            if (map.containsKey(thatNum)) {
                ArrayList<Integer> tempList = new ArrayList<>(map.get(thatNum));
                tempList.add(thatNum);
                result.add(tempList);
            }

            //把当前数对应的两数组合都保存到map里
            //遍历之前所有的数,故范围是到i截止
            //之前所有的数作两两组合，是否有两数组合出现，有的话则存在map中
            for (int j = 0; j < i; j++) {
                int newKey = nums[i] + nums[j];
                if (!map.containsKey(newKey)) {
                    ArrayList<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[j]);
                    //将其加入map中
                    map.put(newKey, tempList);
                }
            }
        }
        return result;
    }

    //双指针法
    public List<List<Integer>> threeSum03(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        //排序
        BubbleSort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lp = i + 1;
            int rp = n - 1;

            while (lp < rp) {
                int sum = nums[i] + nums[lp] + nums[rp];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[lp], nums[rp]));
                    rp--;
                    lp++;
                    while (lp < rp && nums[lp] == nums[lp - 1]) lp++;
                    while (lp < rp && nums[rp] == nums[rp + 1]) rp--;
                } else if (sum < 0) {
                    lp++;
                } else {
                    rp--;
                }
            }
        }
        return result;
    }

    public void BubbleSort(int[] nums) {
        int n = nums.length;
        //外层次数循环从1开始
        for (int i = 1; i < n; i++) {
            //内层循环是是从0开始
            //随着比完的次数,需要比较的元素也在减少
            for (int j = 0; j < n - i; j++) {
                //内层元素下标的变换是基于j的,而不是基于i的
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {-1, 0, 1, 2, -1, -4};
        ThreeSum threeSum = new ThreeSum();

        threeSum.BubbleSort(input);
//        for (int i : input) {
//            System.out.print(i + "\t");
//        }

        List<List<Integer>> result = threeSum.threeSum03(input);
        System.out.println(result);

    }
}
