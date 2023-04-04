package com.johnny.array;

/**
 * Created on 2023/3/30 01:02. 数组的 二分查找法
 *
 * @author Johnny
 */
public class BinaryLookupTest {
    public static void main(String[] args) {
        int index = binarySearch(new int[] {1, 2, 3, 4, 10, 20, 50, 55, 98, 100}, 3);
        System.out.println(index);
    }

    /** 二分查找法 在 array中寻找 target 目标值的下标
     *
     *  思路是 [left,right] 两边闭合数组 [left,right]值有效 所以 while(left <= right) 有=号
     *
     * */
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] > target) {
                //上面判断了 array[middle] > target, 所以 right = middle -1
                right = middle - 1;
            } else if (array[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}

