package com.wyj.algorithm.test.hashmap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Wuyj
 * @DateTime 2022-03-19 15:52
 * @Version 1.0
 */

//LinkedHashMap
public class LRUCacheWithLinkedHashMap extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCacheWithLinkedHashMap(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (super.get(key) == null) {
            return -1;
        }
        return super.get(key);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheWithLinkedHashMap lRUCache = new LRUCacheWithLinkedHashMap(2);
        lRUCache.put(1, 1); //缓存是 {1=1}
        lRUCache.put(2, 2); //缓存是 {1=1, 2=2}
        //TODO 想要在控制台输出结果,则需要System.out.println将其输出打印
        System.out.println(lRUCache.get(1));   //返回 1
        lRUCache.put(3, 3); //该操作会使得关键字2作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    //返回 -1 (未找到)
        lRUCache.put(4, 4); //该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));     //返回 -1 (未找到)
        System.out.println(lRUCache.get(3));     //返回 3
        System.out.println(lRUCache.get(4));     //返回 4
    }
}
