package com.johnny.linked;

/**
 * Created on 2023/4/3 17:32.
 *
 * <p>单链表的 反转 算法 1.递归法 2.
 *
 * @author Johnny
 */
public class SingleLinkedReversedTest {

    public static void main(String[] args) {

        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        showNode(node1);
        // Node<Integer> reversed = reversed(node1);
        System.out.println("---------reversed--------");
        //Node<Integer> reversed = reversedTwoPoint(node1);
        Node<Integer> reversed = reversedRecursion(node1);
        showNode(reversed);
    }

    static <T> void showNode(Node<T> node) {
        if (node == null) {
            System.out.println("node节点null");
            return;
        }
        Node<T> temp = node;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    static class Node<T> {
        Node<T> next; // next
        T data; // 数据域

        public Node(T data) {
            this.data = data;
        }

        public Node() {}

        @Override
        public String toString() {
            return "Node{data=" + data + '}';
        }
    }

    /**
     * 最好的方式 (双指针法)
     *
     * @param originNode
     * @param <T>
     * @return
     */
    static <T> Node<T> reversedTwoPoint(Node<T> originNode) {
        Node<T> pre = null;
        Node<T> cur = originNode;
        Node<T> next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 头插法进行 反转 (比较好理解)
     *
     * @param originNode:
     * @param <T> :
     * @return :
     */
    static <T> Node<T> reversed(Node<T> originNode) {
        if (originNode == null || originNode.next == null) {
            System.out.println("链表为空 不能反转");
            return null;
        }
        Node<T> cur = originNode;
        //
        Node<T> reverseHead = new Node<>();

        Node<T> next;
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        // 丢弃头结点
        return reverseHead.next;
    }

    /**
     * 递归方式 进行反转
     *
     * @param originNode:
     * @param <T> :
     * @return :
     */
    static <T> Node<T> reversedRecursion(Node<T> originNode) {
        return recursion(null, originNode);
    }

    private static <T> Node<T> recursion(Node<T> pre, Node<T> cur) {
        if (cur == null) {
            return pre;
        }
        Node<T> temp = cur.next;
        cur.next = pre;
        return recursion(cur, temp);
    }
}
