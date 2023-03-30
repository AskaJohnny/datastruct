package com.johnny.queue;

/**
 * Created on 2023/3/30 11:05.
 *
 * <p>数组实现环形队列, 需要留一个空格 所以最多存放maxSize-1个数据
 * https://blog.csdn.net/qq_44287198/article/details/116494219 看这个博客 里面的图 能够很容易理解
 *
 * @author Johnny
 */
public class CircleArrayQueueTest {

    public static void main(String[] args) {
        CircleArray queue = new CircleArray(4);

        System.out.println(queue.isEmpty());
        // 先插入3个数据
        queue.addQueue(10);
        queue.addQueue(20);
        queue.addQueue(30);
        // 看下是否已经满了 true 已经满了 环形队列只能存储 maxSize -1 = 4-1= 3个数据
        System.out.println(queue.isFull());
        // 尝试再插入一个 抛已经满了
        queue.addQueue(40);
        System.out.println(queue.isFull());
        //show 发现确实有一个空缺位置 arr[3] = null
        queue.show();
        //front = 0
        System.out.println(queue.front);
        //rear = 3  这个位置是null
        System.out.println(queue.rear);

        //取2个数据
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());

        queue.show();

        System.out.println("-----------");
        queue.addQueue(40);
        queue.addQueue(50);
        queue.show();

        System.out.println(queue.front);
        System.out.println(queue.rear);
    }

    static class CircleArray {
        int maxSize;
        int front;
        int rear;
        Object[] arr;

        public CircleArray(int arrayMaxSize) {
            this.maxSize = arrayMaxSize;
            this.arr = new Object[maxSize];
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public boolean isFull() {
            return (rear + 1) % maxSize == front;
        }

        public void addQueue(Object value) {
            if (isFull()) {
                System.out.println("队列已经满了");
                return;
            }
            arr[rear] = value;
            rear = (rear + 1) % maxSize;
        }

        public Object getQueue() {
            if (isEmpty()) {
                System.out.println("队列是空的 无法获取");
                return null;
            }
            Object value = arr[front];
            // 可置空 也可不管 等着覆盖
            arr[front] = null;
            front = (front + 1) % maxSize;
            return value;
        }

        public void show() {
            if (isEmpty()) {
                System.out.println("队列是空的 无法获取");
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.println("arr[" + i + "] = " + arr[i]);
            }
        }
    }
}
