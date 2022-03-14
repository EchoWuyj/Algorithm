package com.wyj.algorithm.test.sliding_windows;

import java.util.HashMap;

/**
 * @Author Wuyj
 * @DateTime 2022-03-14 10:53
 * @Version 1.0
 */
public class MinWindowSubstring {
    public String minWindow01(String s, String t) {
        String minSubString = "";
        HashMap<Character, Integer> tCharFre = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int count = tCharFre.getOrDefault(c, 0);
            tCharFre.put(c, count + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + t.length(); j <= s.length(); j++) {
                HashMap<Character, Integer> subStrCharFre = new HashMap<>();
                for (int k = i; k < j; k++) {
                    char c = s.charAt(k);
                    Integer count = subStrCharFre.getOrDefault(c, 0);
                    subStrCharFre.put(c, count + 1);
                }
                if (check(tCharFre, subStrCharFre) && (j - i < minSubString.length() || minSubString.equals(""))) {
                    minSubString = s.substring(i, j);
            }
            }
        }
        return minSubString;
    }

    public boolean check(HashMap<Character, Integer> tFreq, HashMap<Character, Integer> subStrFreq) {
        //遍历t中每个字符的频次,与subStr进行比较
        for (Character character : tFreq.keySet()) {
            if (subStrFreq.getOrDefault(character, 0) < tFreq.get(character)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinWindowSubstring minWindowSubstring = new MinWindowSubstring();
        System.out.println(minWindowSubstring.minWindow01(s, t));
    }
}
