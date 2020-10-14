package com.learning.java.leetcode.Array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

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
        int maxProfit = 0;
        int buyPoint = 0;
        while (buyPoint <= prices.length - 1) {
            int sellPoint = buyPoint + 1;
            int profit = 0;
            while (sellPoint < prices.length && prices[buyPoint] < prices[sellPoint]) {
                int thisProfit = prices[sellPoint] - prices[buyPoint];
                profit = Math.max(profit, thisProfit);
                if (sellPoint == prices.length - 1 || (prices[sellPoint] <= prices[sellPoint - 1] && prices[sellPoint] < prices[sellPoint + 1])) {
                    break;
                }
                sellPoint++;
            }
            buyPoint = sellPoint;
            maxProfit += profit;
        }
        return maxProfit;
    }

    /**
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     *
     * @param nums 给定一个数组
     * @param k 将数组中的元素向右移动 k 个位置，其中 k 是非负数
     */
    public void rotate(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        LinkedList<Integer> list = new LinkedList<>();
        // 取余数是一轮移动的位数
        k = k % nums.length;
        // 数组尾部k个数放入队列
        for (int i = k; i > 0; i--) {
            list.add(nums[nums.length - i]);
        }
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            nums[i] = list.pop();
        }
    }

    /**
     * 输入: [1,2,3,1]
     * 输出: true
     *
     * @param nums 给定一个整数数组，判断是否存在重复元素
     * @return 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false
     */
    public boolean containsDuplicate(int[] nums) {
        // 利用HashSet的特性
        Set<Integer> set = new HashSet<>(nums.length * 2);
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

}
