package com.johnny.queue;

import java.util.Scanner;

/**
 * Created on 2023/3/30 10:04.
 * 这是 单数组队列 不可重复使用的 数组队列
 * @author Johnny
 */
public class ArrayQueueTest {

    public static void main(String[] args) {


        int size = 3;
        int real = 2;
        System.out.println((2) % 4);

        ArrayQueue arrayQueue = new ArrayQueue(3);

        System.out.println("数组队列 测试程序开始...");
        System.out.println("输入a(add) 添加数据到队列");
        System.out.println("输入g(get) 从队列获取一个数据");
        System.out.println("输入l(length) 获取队列的长度");
        System.out.println("输入s(show) 显示队列的头部");

        boolean flag = true;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            String operator = scanner.next();
            switch (operator) {
                case "a":
                    System.out.println("请输入入队数据");
                    String insertValue = scanner.next();
                    arrayQueue.addQueue(Integer.parseInt(insertValue));
                    break;
                case "g":
                    int queue = arrayQueue.getQueue();
                    System.out.println(queue);
                    break;
                case "l":
                    System.out.println(arrayQueue.size());
                    break;
                case "s":
                    System.out.println(arrayQueue.showHeader());
                    break;
                case "exit":
                    System.out.println("程序退出...");
                    flag = false;
                    break;
                default:
                    System.out.println("未找到程序指令,请正确输入");
            }
        }
    }

    static class ArrayQueue {
        int maxSize;
        int front;
        int real;
        int[] array;

        /**
         * 构造一个 固定数量的 队列
         *
         * <p>front 指向队列头部的 前一个位置 real 指向队列尾部
         *
         * @param maxSize: 队列容量
         */
        public ArrayQueue(int maxSize) {
            this.maxSize = maxSize;
            // 初始化这个数组队列
            array = new int[this.maxSize];
            front = -1;
            real = -1;
        }

        public boolean isFull() {
            return real == maxSize - 1;
        }

        public boolean isEmpty() {
            return front == real;
        }

        public void addQueue(int value) {
            if (isFull()) {
                throw new RuntimeException("队列满了 无法添加数据...");
            }
            //添加数据 指向队列尾部的指针 +1 然后存入数据
            real++;
            array[real] = value;
        }

        public int getQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列是空 无法获取数据...");
            }
            front++;
            return array[front];
        }

        public int size() {
            return array.length;
        }

        public int showHeader() {
            if (isEmpty()) {
                throw new RuntimeException("队列是空 无法获取数据...");
            }
            return array[front + 1];
        }
    }
}
