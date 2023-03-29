package com.johnny.array;

/**
 * Created on 2023/3/30 00:08.
 *
 * @author Johnny
 */
public class SpareArrayTest {

    public static void main(String[] args) {
        int[][] checkboard = new int[11][11];
        // 初始化几个值
        checkboard[1][2] = 1;
        checkboard[2][3] = 2;
        checkboard[4][6] = 2;
        checkboard[5][8] = 1;

        System.out.println("原始数组打印：");
        for (int i = 0; i < checkboard.length; i++) {
            for (int i1 = 0; i1 < checkboard[i].length; i1++) {
                System.out.printf("%d\t", checkboard[i][i1]);
            }
            System.out.println();
        }

        int[][] spareArray = toSpareArray(checkboard);
        System.out.println("稀疏数组打印：");
        for (int i = 0; i < spareArray.length; i++) {
            System.out.printf(
                    "%d\t %d\t %d\t", spareArray[i][0], spareArray[i][1], spareArray[i][2]);
            System.out.println(); // 换行
        }

        int [][] normalArray = spareToArray(spareArray);

        System.out.println("稀疏转原始数组打印：");
        for (int i = 0; i < checkboard.length; i++) {
            for (int i1 = 0; i1 < checkboard[i].length; i1++) {
                System.out.printf("%d\t", checkboard[i][i1]);
            }
            System.out.println();
        }
    }

    /**
     * 二维数组转 稀疏数组
     *
     * @param array: 原始二维数组
     * @return : 稀疏数组
     *     <p>核心思想确定 effectCount 数量
     */
    static int[][] toSpareArray(int[][] array) {

        if (array == null || array.length == 0) {
            return null;
        }
        int effectCount = 0;
        int lineLength = array.length;
        int columnLength = array[0].length;

        // 确定effectCount
        for (int[] ints : array) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    effectCount++;
                }
            }
        }
        int[][] spareArray = new int[effectCount + 1][3];
        spareArray[0][0] = lineLength;
        spareArray[0][1] = columnLength;
        spareArray[0][2] = effectCount;

        int effectIndex = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    spareArray[effectIndex][0] = i;
                    spareArray[effectCount][1] = j;
                    spareArray[effectCount][2] = array[i][j];
                    effectIndex++;
                }
            }
        }
        return spareArray;
    }

    static int[][] spareToArray(int[][] spareArray) {
        if (spareArray == null || spareArray.length == 0) {
            return null;
        }
        int lineLength = spareArray[0][0];
        int columnLength = spareArray[0][1];
        int effectCount = spareArray[0][2];

        int[][] array = new int[lineLength][columnLength];

        for (int i = 1; i <= effectCount; i++) {
            int lineIndex = spareArray[i][0];
            int columnIndex = spareArray[i][1];
            int value = spareArray[i][2];
            array[lineIndex][columnIndex] = value;
        }
        return array;
    }
}
