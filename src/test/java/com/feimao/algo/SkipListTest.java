package com.feimao.algo;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: feimao
 * @Date: 21-3-8 下午9:17
 */
public class SkipListTest {

    @Test
    public void test() {
        SkipList skipList = new SkipList();
        skipList.insert(4);
        skipList.insert(2);
        skipList.insert(15);
        skipList.insert(6);
        skipList.insert(1);
        Assert.assertNull(skipList.search(3));
        Assert.assertEquals(skipList.search(1).data, 1);
        Assert.assertEquals(skipList.search(2).data, 2);
        Assert.assertEquals(skipList.search(4).data, 4);
        Assert.assertEquals(skipList.search(6).data, 6);
        Assert.assertEquals(skipList.search(15).data, 15);
        skipList.delete(1);
        skipList.delete(2);
        skipList.delete(3);
        skipList.delete(4);
        skipList.delete(6);
        skipList.delete(15);
    }
}
