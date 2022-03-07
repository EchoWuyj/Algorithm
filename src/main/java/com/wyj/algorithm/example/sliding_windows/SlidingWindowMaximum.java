package com.wyj.algorithm.example.sliding_windows;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author Wuyj
 * @DateTime 2022-03-04 13:32
 * @Version 1.0
 */
public class SlidingWindowMaximum {
    //方法一:暴力法,遍历每一个窗口,对每个窗口遍历每个元素求最大值
    public int[] maxSlidingWindow01(int[] nums, int k) {
        //定义一个结果数组,总共有n-k+1个窗口
        //其中每个窗口都有个最大值,所以需要你使用这么长的数组来存储
        int[] result = new int[nums.length - k + 1];

        //遍历数组,从0到n-k,作为滑动窗口的起始位置
        //数组的长度-滑动窗口的长度=滑动窗口的起始位置的索引
        //注意i是取到nums.length - k
        for (int i = 0; i <= nums.length - k; i++) {
            //找窗口内的最大值,定义一个变量来保存
            int max = nums[i];
            //遍历窗口中的每一个元素,比较大小
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            result[i] = max;
        }
        return result;
    }

    //方法二:使用大顶堆
    public int[] maxSlidingWindow02(int[] nums, int k) {
        //定义一个结果数组
        int[] result = new int[nums.length - k + 1];

        //用优先队列实现一个大顶堆
        //k为队列的大小,默认是小顶堆,想要实现大顶堆需要传入比较器
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //倒序则是后减前,正序则是前减后
                return o2 - o1;
            }
        });

        //准备工作:构建大顶堆,将第一个窗口元素（前k个）放入堆中
        for (int i = 0; i < k; i++) {
            //通过大顶堆的数据结构会自动实现大的元素上浮,小的元素下沉
            maxHeap.add(nums[i]);
        }

        //当前大顶堆的堆顶元素就是第一个窗口的最大值
        result[0] = maxHeap.peek();

        //遍历所有窗口
        //从第二窗口开始即可
        for (int i = 1; i <= nums.length - k; i++) {
            //删除堆中上一个窗口的第一个元素
            maxHeap.remove(nums[i - 1]);
            //添加当前窗口的最后一个元素进堆
            //TODO 数学原理:数组始末索引0和n-1,项数=(n-1-0)+1=n
            //当前元素索引为i,窗口长度为k,则窗口最后一个元素索引为i+k-1
            maxHeap.add(nums[i + k - 1]);
            result[i] = maxHeap.peek();
        }
        return result;
    }

    //方法三:使用双向队列
    public int[] maxSlidingWindow03(int[] nums, int k) {
        //定义一个结果数组
        int[] result = new int[nums.length - k + 1];

        //定义双向队列,保存元素的索引
        //在队前进行删除操作,在对尾进行添加和删除操作,所以使用双向队列
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        //初始化双向队列,处理第一个窗口的数据
        for (int i = 0; i < k; i++) {
            //如果队尾元素小于当前元素,直接删除
            //且不停地往前判断,只要有比当前元素小的元素即全部删除
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            //往队尾添加元素
            deque.addLast(i);
        }

        //第一个窗口的最大值
        result[0] = nums[deque.getFirst()];

        //此时已经不需要遍历窗口了,因为从已经将索引0到k-1元素都已经判断了,当前的最大值已经有了
        //遍历数组所有元素,
        // 作为窗口的结束位置
        for (int i = k; i < nums.length; i++) {

        }
        return null;
    }

    public static void main(String[] args) {
        int[] input = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] output = slidingWindowMaximum.maxSlidingWindow02(input, k);

        for (int i : output) {
            System.out.print(i + "\t");
        }
    }
}


