package com.feimao.algo;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: feimao
 * @Date: 21-3-8 下午8:18
 */
public class BinarySearchTest {

    @Test
    public void binarySearch() {
        int[] arr = {0, 3, 6, 7};
        Assert.assertEquals(1, BinarySearch.search(arr, 3));
        Assert.assertEquals(-1, BinarySearch.search(arr, -1));
        Assert.assertEquals(-1, BinarySearch.search(arr, 8));
        Assert.assertEquals(-1, BinarySearch.search(arr, 2));
    }
}
