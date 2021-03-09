package com.feimao.algo;

import java.util.Random;

/**
 * @Author: feimao
 * @Date: 21-3-8 下午8:24
 */
public class SkipList {

    private static final double PROMOTE_RATE = 0.5; //晋升概率
    public Node head;

    public SkipList() {
        head = new Node(Integer.MIN_VALUE);
    }

    public Node search(int tar) {
        Node node = doSearch(tar);
        return node.data == tar ? node : null;
    }

    private Node doSearch(int tar) {
        Node cur = head;
        while (true) {
            if (cur.next != null && cur.next.data <= tar) {
                cur = cur.next;
            } else if (cur.down != null) {
                cur = cur.down;
            } else {
                break;
            }
        }
        return cur;
    }

    public void insert(int tar) {
        Node prev = doSearch(tar);
        if (prev.data == tar) {
            return;
        }
        Node cur = new Node(tar);
        prev.append(cur);

        Random random = new Random();
        while (random.nextDouble() < PROMOTE_RATE) {
            //概率晋升
            while (prev.up == null && prev.prev != null) {
                prev = prev.prev;
            }
            if (prev.up == null) {
                head = new Node(Integer.MIN_VALUE)  ;
                prev.up(head);
            }
            prev = prev.up;
            Node promote = new Node(tar);
            prev.append(promote);
            cur.up(promote);
            cur = promote;
        }
    }

    public void delete(int tar) {
        Node node = search(tar);
        while (node != null) {
            node.prev.next = node.next;
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            if (node.prev.data == Integer.MIN_VALUE && node.prev.next == null && node.prev.down != null) {
                //清理空的索引
                head = node.prev.down;
                node.prev.down = null;
                head.up = null;
                return;
            }
            node = node.up;
        }
    }

    public class Node {
        public int data;
        public Node prev;
        public Node next;
        public Node up;
        public Node down;

        public Node(int data) {
            this.data = data;
        }

        public void append(Node node) {
            Node next = this.next;
            if (next == null) {
                this.next = node;
                node.prev = this;
            } else {
                this.next = node;
                node.prev = this;
                node.next = next;
                next.prev = node;
            }
        }

        public void up(Node node) {
            if (this.up != null) {
                throw new IllegalArgumentException();
            } else {
                this.up = node;
                node.down = this;
            }
        }
    }
}
