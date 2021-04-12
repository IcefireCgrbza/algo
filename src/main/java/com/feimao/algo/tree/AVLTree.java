package com.feimao.algo.tree;

/**
 * @Author: feimao
 * @Date: 21-3-10 下午5:20
 */
public class AVLTree extends BinaryTree {

    @Override
    public Node insert(int data) {
        Node node = super.insert(data);
        if (node == null) {
            return null;
        }
        rotateAt(node);
        return node;
    }

    private void rotateAt(Node node) {
        Node cur = node;
        while (cur != null) {
            int balance = isBalance(cur);
            if (balance > 1) {
                if (isBalance(cur.left) >= 1) {
                    //ll
                    cur = llRotate(cur);
                } else {
                    //lr
                    cur = lrRotate(cur);
                }
            } else if (balance < -1) {
                if (isBalance(cur.right) >= 1) {
                    cur = rlRotate(cur);
                } else {
                    cur = rrRotate(cur);
                }
            }

            if (cur.parent == null) {
                this.root = cur;
                break;
            }

            cur = cur.parent;
        }
    }

    private int isBalance(Node node) {
        int leftDepth = node.left == null ? 0 : node.left.depth;
        int rightDepth = node.right == null ? 0 : node.right.depth;
        return leftDepth - rightDepth;
    }

    private Node llRotate(Node node) {
        Node parent = node.parent;
        Node son = node.left;
        Node grandson = son.right;
        if (grandson != null) {
            grandson.parent = node;
        }
        node.left = grandson;
        updateDepth(node);
        node.parent = son;
        son.right = node;
        updateDepth(son);
        son.parent = parent;
        if (parent != null) {
            if (parent.left == node) {
                parent.left = son;
            } else {
                parent.right = son;
            }
        }
        return son;
    }

    private Node rrRotate(Node node) {
        Node parent = node.parent;
        Node son = node.right;
        Node grandson = son.left;
        if (grandson != null) {
            grandson.parent = node;
        }
        node.right = grandson;
        updateDepth(node);
        node.parent = son;
        son.left = node;
        updateDepth(son);
        son.parent = parent;
        if (parent != null) {
            if (parent.left == node) {
                parent.left = son;
            } else {
                parent.right = son;
            }
        }
        return son;
    }

    private Node lrRotate(Node node) {
        rrRotate(node.left);
        return llRotate(node);
    }

    private Node rlRotate(Node node) {
        llRotate(node.right);
        return rrRotate(node);
    }

    @Override
    public Node search(int data) {
        return super.search(data);
    }

    @Override
    public void delete(int data) {
        super.delete(data);
    }

    private void updateDepth(Node node) {
        int leftDepth = node.left == null ? 0 : node.left.depth;
        int rightDepth = node.right == null ? 0 : node.right.depth;
        node.depth = Math.max(leftDepth, rightDepth) + 1;
    }
}
