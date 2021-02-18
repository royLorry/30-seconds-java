package com.learning.java.leetcode.Array;

import java.util.*;

public class ArraySolution {

    /**
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * <p>
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * <p>
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
     * @param k    将数组中的元素向右移动 k 个位置，其中 k 是非负数
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

    /**
     * @param nums 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次
     * @return 找出那个只出现了一次的元素
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
            i += 2;
        }
        return nums[i];
    }

    /**
     * @param nums1 给定两个数组
     * @param nums2 给定两个数组
     * @return 返回它们的交集
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] intersectArray;
        // 选取长度小的那个
        int[] longerArray = nums1.length > nums2.length ? nums1 : nums2;
        int[] shorterArray = nums1.length > nums2.length ? nums2 : nums1;


        return null;
    }

    /**
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * @param digits 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * @return 返回加一后的数组
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + 1;
            if (sum == 10) {
                digits[i] = 0;
            } else {
                digits[i] = sum;
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        System.arraycopy(digits, 0, result, 1, digits.length);
        result[0] = 1;
        return result;
    }

    /**
     * @param nums 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     */
    public void moveZeroes(int[] nums) {
        // 记住当前有几个0，则为非0向前需要移动的位数
        int zeroNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNum++;
            } else {
                // 交换
                int temp = nums[i];
                nums[i] = nums[i - zeroNum];
                nums[i - zeroNum] = temp;
            }
        }
    }

    /**
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * @param nums 给定一个整数数组
     * @param target 一个目标值 target
     * @return 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length * 2);
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (!map.containsKey(difference)) {
                map.put(difference, i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (map.get(nums[i]) != i) {
                    return new int[]{i, map.get(nums[i])};
                }
            }
        }
        return null;
    }

    /**
     *
     * @param board 一个 9x9 的数独
     * @return 判断是否有效
     */
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] lineSet = new HashSet[9];
        HashSet<Character>[] verticalSet = new HashSet[9];
        HashSet<Character>[][] blockSet = new HashSet[3][3];
        for (int i = 0; i < lineSet.length; i++) {
            lineSet[i] = new HashSet<>(20);
        }
        for (int i = 0; i < verticalSet.length; i++) {
            verticalSet[i] = new HashSet<>(20);
        }
        for (int i = 0; i < blockSet.length; i++) {
            for (int j = 0; j < blockSet[i].length; j++) {
                blockSet[i][j] = new HashSet<>(20);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char currentChar = board[i][j];
                if (currentChar != '.') {
                    if (lineSet[i].contains(currentChar)) {
                        return false;
                    } else {
                        lineSet[i].add(currentChar);
                    }

                    if (verticalSet[j].contains(currentChar)) {
                        return false;
                    } else {
                        verticalSet[j].add(currentChar);
                    }

                    if (blockSet[i / 3][j / 3].contains(currentChar)) {
                        return false;
                    } else {
                        blockSet[i / 3][j / 3].add(currentChar);
                    }
                }
            }
        }
        return true;
    }


    public void rotate(int[][] matrix) {
        int sideLength = matrix.length;
        for (int i = 0; i < sideLength / 2; i++) {
            int j = i;
            while (i + j < sideLength - 1 - i) {
                int targetI = 
                j++;
            }
        }
    }


}
