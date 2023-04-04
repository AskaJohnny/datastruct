package com.johnny.linked;

import java.util.Objects;

/**
 * Created on 2023/4/4 18:03.
 *
 * @author Johnny
 */
public class Node<T> {
    /** next */
    Node<T> next;
    /** 数据域 */
    T data;

    public Node(T data) {
        this.data = data;
    }

    public Node() {}

    @Override
    public String toString() {
        return "Node{data=" + data + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node<?> node = (Node<?>) o;
        return Objects.equals(data, node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
