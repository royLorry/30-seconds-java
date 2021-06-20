package com.learning.java.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class StringSolution {

    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     *
     * @param s 输入字符串
     */
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        char c;
        while (i < j) {
            c = s[i];
            s[i] = s[j];
            s[j] = c;
            i++;
            j--;
        }
    }

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * @param s 字符串
     * @param t 字符串
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (charCountMap.containsKey(c)) {
                Integer count = charCountMap.get(c);
                count++;
                charCountMap.put(c, count);
            } else {
                charCountMap.put(c, 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            if (charCountMap.containsKey(c)) {
                Integer count = charCountMap.get(c);
                count--;
                if (count == 0) {
                    charCountMap.remove(c);
                } else {
                    charCountMap.put(c, count);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isAnagram("aacc", "ccac");
    }

}
