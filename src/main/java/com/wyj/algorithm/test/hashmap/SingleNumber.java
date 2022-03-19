package com.wyj.algorithm.test.hashmap;

import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author Wuyj
 * @DateTime 2022-03-19 13:23
 * @Version 1.0
 */
public class SingleNumber {
    public int singleNumber01(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for (Integer num : nums) {
            if (list.contains(num)) {
                list.remove(num);
            } else {
                list.add(num);
            }
        }
        return list.get(0);
    }

    //哈希表
    public int singleNumber02(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            //对于没有存入的num
            if (hashMap.get(num) != null) {
                hashMap.remove(num);
            } else {
                hashMap.put(num, 1);
            }
        }
        return hashMap.keySet().iterator().next();
    }

    public int singleNumber03(int[] nums) {
        //定义一个HashSet去重
        HashSet<Integer> set = new HashSet<>();
        int arraySum = 0;
        int setSum = 0;

        for (int num : nums) {
            set.add(num);
            arraySum += num;
        }

        for (Integer integer : set) {
            setSum += integer;
        }

        return setSum * 2 - arraySum;
    }

    //通过位运算
    public int singleNumber04(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber04(nums));
    }
}
