package com.feimao.algo.sort;

import com.feimao.algo.sort.impl.BubbleSort;
import com.feimao.algo.sort.impl.BucketSort;
import com.feimao.algo.sort.impl.CountSort;
import com.feimao.algo.sort.impl.HeapSort;
import com.feimao.algo.sort.impl.InsertSort;
import com.feimao.algo.sort.impl.MergeSort;
import com.feimao.algo.sort.impl.QuickSort;
import com.feimao.algo.sort.impl.RadixSort;
import com.feimao.algo.sort.impl.SelectSort;
import com.feimao.algo.sort.impl.ShellSort;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: feimao
 * @Date: 21-2-27 上午9:22
 */
public class SortTest {

    private int[] arr;

    @Before
    public void init() {
        arr = new int[]{2, 5, 1, 3, 8, 5, 7, 4, 3};
    }

    @After
    public void print() {
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void select() {
        Sort sort = new SelectSort();
        sort.sort(arr);
    }

    @Test
    public void insert() {
        Sort sort = new InsertSort();
        sort.sort(arr);
    }

    @Test
    public void shell() {
        Sort sort = new ShellSort();
        sort.sort(arr);
    }

    @Test
    public void bubble() {
        Sort sort = new BubbleSort();
        sort.sort(arr);
    }

    @Test
    public void quick() {
        Sort sort = new QuickSort();
        sort.sort(arr);
    }

    @Test
    public void merge() {
        Sort sort = new MergeSort();
        sort.sort(arr);
    }

    @Test
    public void heap() {
        Sort sort = new HeapSort();
        sort.sort(arr);
    }

    @Test
    public void count() {
        Sort sort = new CountSort();
        sort.sort(arr);
    }

    @Test
    public void bucket() {
        Sort sort = new BucketSort();
        sort.sort(arr);
    }

    @Test
    public void radix() {
        Sort sort = new RadixSort();
        sort.sort(arr);
    }
}
