package com.feimao.algo.tree;

/**
 * @Author: feimao
 * @Date: 21-3-10 下午5:29
 */
public class Node {

    public int data;
    public Node parent;
    public Node left;
    public Node right;
    public int depth;

    Node(int data) {
        this.data = data;
    }
}
