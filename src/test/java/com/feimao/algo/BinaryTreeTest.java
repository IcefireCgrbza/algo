package com.feimao.algo;

import com.feimao.algo.tree.BinaryTree;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: feimao
 * @Date: 21-3-9 下午8:59
 */
public class BinaryTreeTest {

    @Test
    public void test() {
        BinaryTree tree = new BinaryTree();
        tree.insert(50);
        tree.insert(25);
        tree.insert(15);
        tree.insert(5);
        tree.insert(20);
        tree.insert(35);
        tree.insert(30);
        tree.insert(40);
        tree.insert(60);
        Assert.assertNull(tree.search(70));
        searchExist(tree, 5);
        searchExist(tree, 15);
        searchExist(tree, 20);
        searchExist(tree, 25);
        searchExist(tree, 30);
        searchExist(tree, 35);
        searchExist(tree, 40);
        searchExist(tree, 50);
        searchExist(tree, 60);
        tree.delete(70);
        tree.delete(60);
        tree.delete(50);
        tree.delete(25);
        tree.delete(30);
    }

    private void searchExist(BinaryTree tree, int data) {
        Assert.assertEquals(tree.search(data).data, data);
    }
}
