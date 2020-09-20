package com.learning.java.leetcode.Array;

public class ArraySolution {

    /**
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     *
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums 排序后的整型数组
     * @return 移除后数组的新长度
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else if (j > i + 1) {
                nums[i + 1] = nums[j];
                i++;
                j++;
            } else {
                i++;
                j++;
            }
        }
        return i + 1;
    }

    /**
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     *
     * @param prices 第 i 个元素是一支给定股票第 i 天的价格
     * @return 所能获取的最大利润
     */
    public int maxProfit(int[] prices) {
        return 0;
    }

}
