package com.johnny.linked;

import java.util.HashSet;

/**
 * Created on 2023/4/4 17:40. 检测链表是否有环 https://blog.csdn.net/yizhizainulii/article/details/121992157
 *
 * <p>https://blog.csdn.net/qq_43142792/article/details/123217778
 *
 * @author Johnny
 */
public class SingleLinkedHasCycleTest {

    public static void main(String[] args) {
        // 创建 带环形的 链表
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        // 环形
        // node5.next = node3;
        // 非环形
        node5.next = null;

        System.out.println(hasCycle(node1));

        Boolean existCycle = hasCycleByHash(node1);
        System.out.println(existCycle);

        System.out.println(hasCycleAndReturn(node1));
    }

    /**
     * 检测 链表是否有环形 1.快慢指针法 定义两个指针 fast 和 slow fast一次走2步 slow一次走一步 如果有环形 fast会先进入环形 然后转圈圈 slow 再进环形,
     * 他俩一定会在圈内相遇
     *
     * @param node:
     * @param <T>:
     * @return :
     */
    static <T> Boolean hasCycle(Node<T> node) {
        if (node == null || node.next == null || node.next.next == null) {
            // 不存在环形
            return null;
        }
        Node<T> fast = node.next.next;
        Node<T> slow = node.next;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                // 当fast后面没有了就表示链表到头了 不存在环形
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * 判断是否有环 并且找到环的入口 思路就是: 再相遇的地方 定义为 index1 , head 定义为 index2 , 她俩每次向后走一步 直到相遇就是入口 返回
     * index1/index2 x表示 头结点到 环形入口节点的的距离 n 标识fast转了几圈, y+z 表示一圈 z表示 相遇节点到 环形入口节点距离
     *
     * 因为fast指针是一步走两个节点，slow指针一步走一个节点， 所以 fast指针走过的节点数 = slow指针走过的节点数 * 2：
     *
     * <p>(x + y) * 2 = x + y + n (y + z)
     *
     * <p>x = (n-1) (y+z) + z 注意这里n一定是大于等于1的，因为 fast指针至少要多走一圈才能相遇slow指针。
     *
     * @param node
     * @param <T>
     * @return
     */
    static <T> Node<T> hasCycleAndReturn(Node<T> node) {
        Node<T> fast = node;
        Node<T> slow = node;
        // 当fast后面没有了就表示链表到头了 不存在环形
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                Node<T> index1 = fast;
                Node<T> index2 = node;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index2;
            }
        }
        return null;
    }

    /**
     * 使用 hashset来判断是否有环形 每次比较一下 hashset里面是否存在node , 如果不存在则插入
     *
     * @param node:
     * @param <T>:
     * @return :
     */
    static <T> Boolean hasCycleByHash(Node<T> node) {
        HashSet<Node<T>> hashSet = new HashSet<>();
        Node<T> temp = node;
        while (temp != null) {
            if (hashSet.contains(temp)) {
                return true;
            } else {
                hashSet.add(temp);
            }
            temp = temp.next;
        }
        return false;
    }
}
