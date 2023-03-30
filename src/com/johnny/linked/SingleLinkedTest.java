package com.johnny.linked;

/**
 * Created on 2023/3/30 15:29.
 * 单链表是一种链式存储结构，它由多个节点（Node）组成，每个节点包含两个域：数据域（Data）和指针域（Next）。其中，数据域用于存储节点的数据，指针域用于指向下一个节点的地址。
 * 单链表的特点如下：
 *
 * <p>链表是一种动态数据结构，可以随时进行插入、删除等操作，不需要预先定义大小，具有很大的灵活性。
 *
 * <p>链表的节点可以不连续存储，可以在内存中任意位置分配空间，因此可以充分利用内存空间。
 *
 * <p>链表的插入、删除等操作相对数组来说更加高效，因为只需要修改指针域即可，不需要进行大量的数据搬移。
 *
 * <p>链表的查找操作相对数组来说比较低效，因为需要从头节点开始遍历整个链表，时间复杂度为O(n)。
 *
 * <p>单链表只能从前往后遍历，无法实现反向遍历，因为每个节点只有一个指针域指向下一个节点。
 * 综上所述，单链表适合插入、删除频繁的场景，但不适合查找操作比较频繁的场景。对于需要反向遍历的场景，可以使用双向链表。
 *
 * <p>单链表的 实现 本例子中 addToList 是不能根据 number排序的,addToListOrderBy 是根据number 排序的
 *
 * <p>场景: 比如 client 定期发送一批 在线好友的序号到 server端 如 3,2,10,5,8... , server端用单链表 把这批好友在内存中进行排序然后返回给 client
 *
 * <p>单链表场景:
 *
 * <p>1.缓存系统LRU：缓存系统可以使用单链表来实现数据的缓存和淘汰。新的数据可以添加到链表的头部，当链表达到一定长度或者数据过期时，可以从链表尾部淘汰一些数据。
 * 2.浏览器历史记录：浏览器历史记录可以使用单链表来实现。每当用户访问一个新的网页，就可以将该网页添加到链表的头部，当链表达到一定长度时，可以从链表尾部删除一些历史记录。
 * 3.线性表：单链表可以用来实现线性表，它可以支持插入、删除、查找等操作，并且插入和删除的效率比数组高。
 * 4.拓扑排序：拓扑排序是一种常用的图算法，它可以用来解决依赖关系的问题。拓扑排序可以使用单链表来实现，每个节点表示一个任务或者一个依赖关系，链表中的顺序就是任务的执行顺序。
 * 总之，单链表是一种非常常用的数据结构，可以在许多场景中使用。它简单、高效，可以帮助我们更好地组织和管理数据。
 *
 * @author Johnny
 */
public class SingleLinkedTest {

    public static void main(String[] args) {

        SingleLinked singleLinked = new SingleLinked();
        singleLinked.showList();

        HeroNode node1 = new HeroNode(1, "索尔", "雷神");
        HeroNode node2 = new HeroNode(2, "罗伯特", "钢铁侠");
        HeroNode node3 = new HeroNode(3, "韦恩", "蝙蝠侠");
        HeroNode node4 = new HeroNode(4, "彼得", "蜘蛛侠");

        // 这里是 没有根据number排序的 直接一个个添加的
        //        singleLinked.addToList(node1);
        //        singleLinked.addToList(node3);
        //        singleLinked.addToList(node2);
        //        singleLinked.addToList(node4);

        // 这里是进行了排序 并且不能number重复
        singleLinked.addToListOrderBy(node1);
        singleLinked.addToListOrderBy(node3);
        singleLinked.addToListOrderBy(node2);
        singleLinked.addToListOrderBy(node4);

        singleLinked.addToListOrderBy(node2);

        singleLinked.showList();
    }

    static class SingleLinked {
        HeroNode head = new HeroNode();

        void addToList(HeroNode node) {
            HeroNode temp = head;
            // 从head 一直找到最后一个node元素,
            while (temp.next != null) {
                temp = temp.next;
            }
            // 把最后一个元素的 next 指向 新加入的node
            temp.next = node;
        }

        void addToListOrderBy(HeroNode node) {
            HeroNode temp = head;
            boolean existFlag = false;
            // 处理 第一个node添加进来的情况
            if (temp.next == null) {
                head.next = node;
                return;
            }

            while (temp.next != null) {
                if (temp.next.number < node.number) {
                    temp = temp.next;
                } else if (temp.next.number == node.number) {
                    // 已经存在
                    existFlag = true;
                    break;
                } else {
                    break;
                }
            }
            if (existFlag) {
                System.out.println("要添加的节点编号(" + node.number + ")已存在~~");
                return;
            }
            node.next = temp.next;
            temp.next = node;
        }

        void showList() {
            if (head.next == null) {
                System.out.println("链表为空...");
            }
            HeroNode temp = head;
            while (temp.next != null) {
                System.out.println(temp.next);
                temp = temp.next;
            }
        }
    }

    static class HeroNode {
        int number;
        String name;
        String nickName;
        HeroNode next;

        public HeroNode() {}

        public HeroNode(int number, String name, String nickName) {
            this.number = number;
            this.name = name;
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "HeroNode{"
                    + "number="
                    + number
                    + ", name='"
                    + name
                    + '\''
                    + ", nickName='"
                    + nickName
                    + '\''
                    + '}';
        }
    }
}
