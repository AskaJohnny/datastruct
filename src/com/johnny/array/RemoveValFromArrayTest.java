package com.johnny.array;

/**
 * Created on 2023/4/7 10:09. 从数组中 数组——移除元素（暴力+双指针）
 *
 * <p>给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * <p>不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * <p>元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/remove-element
 *
 * @author Johnny
 */
public class RemoveValFromArrayTest {

    public static void main(String[] args) {
        int[] arrays = new int[] {1, 2, 3, 0, 3, 0, 1, 22};
        int[] arrays2 = new int[] {3, 2, 2, 3};
        int count = removeVal(arrays2, 3);
        System.out.println(count);
    }

    /**
     * 暴力破解法 思路: 第一层循环找到数组中 和val相同的值 然后第二层循环把当前位置后面的所有都 向前移动覆盖
     *
     * @param nums:
     * @param val:
     * @return :
     */
    static int removeVal(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < length; j++) {
                    nums[j - 1] = nums[j];
                }
                length--;
                i--;
            }
        }
        return length;
    }
}
