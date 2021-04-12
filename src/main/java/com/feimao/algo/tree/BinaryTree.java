package com.feimao.algo.tree;

/**
 * @Author: feimao
 * @Date: 21-3-9 下午8:34
 */
public class BinaryTree {

    protected Node root;

    public Node insert(int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
            return node;
        }
        Node parent = root;
        while (true) {
            if (parent.data == data) {
                return null;
            } else if (parent.data > data) {
                if (parent.left == null) {
                    parent.left = node;
                    parent.left.parent = parent;
                    return node;
                } else {
                    parent = parent.left;
                }
            } else {
                if (parent.right == null) {
                    parent.right = node;
                    parent.right.parent = parent;
                    return node;
                } else {
                    parent = parent.right;
                }
            }
        }
    }

    public Node search(int data) {
        Node cur = root;
        while (cur != null) {
            if (cur.data == data) {
                return cur;
            } else if (cur.data > data) {
                if (cur.left == null) {
                    return null;
                } else {
                    cur = cur.left;
                }
            } else {
                if (cur.right == null) {
                    return null;
                } else {
                    cur = cur.right;
                }
            }
        }
        return null;
    }

    public void delete(int data) {
        Node cur = search(data);
        if (cur == null) {
            return;
        }
        if (cur.left == null && cur.right == null) {
            if (cur.parent == null) {
                root = null;
            } else if (cur.parent.left == cur) {
                cur.parent.left = null;
            } else {
                cur.parent.right = null;
            }
        } else if (cur.left == null) {
            if (cur.parent == null) {
                root = cur.right;
            } else if (cur.parent.left == cur) {
                cur.parent.left = cur.right;
            } else {
                cur.parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur.parent == null) {
                root = cur.left;
            } else if (cur.parent.left == cur) {
                cur.parent.left = cur.left;
            } else {
                cur.parent.right = cur.left;
            }
        } else {
            Node next = cur.right;
            if (next.left == null) {
                cur.right = next.right;
                cur.data = next.data;
                return;
            }
            while (next.left != null) {
                //找右子树中最小的节点
                next = next.left;
            }
            cur.data = next.data;
            next.parent.left = next.right;
        }
    }
}
