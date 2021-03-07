package com.feimao.algo.sort.impl;

import com.feimao.algo.sort.Sort;

/**
 * @Author: feimao
 * @Date: 21-2-27 上午10:04
 */
public class QuickSort extends Sort {

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int base = left;
        int i = left;
        int j = right;
        while (i < j) {
            while (arr[base] <= arr[j] && i < j) {
                //右边先走
                j--;
            }
            while (arr[base] >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }

        swap(arr, base, i);

        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }
}
