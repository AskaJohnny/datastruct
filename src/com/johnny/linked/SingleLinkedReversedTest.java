package com.johnny.linked;

import java.util.Stack;

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
        // Node<Integer> reversed = reversedTwoPoint(node1);
        Node<Integer> reversed = reversedRecursion(node1);
        showNode(reversed);

        //递归 打印
        reversedPrint(reversed);
        //借助 stack 栈 打印
        reversedPrintUseStack(reversed);
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
            // 最终返回 最后一个pre 尾指针
            return pre;
        }
        Node<T> temp = cur.next;
        cur.next = pre;
        // 处理下一个就调用节点 递归方法,  递归方法里 再找下个个 并且反转当前的cur.next=pre
        return recursion(cur, temp);
    }

    /**
     * 逆序 打印单链表 从尾部打印
     *
     * @param node
     * @param <T>
     */
    static <T> void reversedPrint(Node<T> node) {
        Node<T> temp = node.next;
        if (temp != null) {
            reversedPrint(temp);
        }
        System.out.println(node);
    }

    /**
     * 逆序 打印单链表 从尾部打印 借助 stack 栈
     * @param node
     * @param <T>
     */
    static <T> void reversedPrintUseStack(Node<T> node) {
        if (node == null) {
            System.out.println("空链表");
            return;
        }
        Node<T> temp = node;
        Stack<Node<T>> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}
