package com.feimao.algo.sort.impl;

import com.feimao.algo.sort.Sort;

/**
 * @Author: feimao
 * @Date: 21-2-28 下午3:34
 */
public class MergeSort extends Sort {

    @Override
    public void sort(int[] arr) {
        System.arraycopy(mergeSort(arr, 0, arr.length - 1), 0, arr, 0, arr.length);
    }

    private int[] mergeSort(int[] arr, int left, int right) {
        if (left > right) {
            throw new IllegalArgumentException("left is bigger than right");
        }
        if (left == right) {
            return new int[] {arr[left]};
        }

        int mid = (left + right) / 2;
        return merge(mergeSort(arr, left, mid), mergeSort(arr, mid + 1, right));
    }

    private int[] merge(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int idx = 0, idx1 = 0, idx2 = 0;
        while (idx1 < arr1.length || idx2 < arr2.length) {
            if (idx1 >= arr1.length) {
                arr[idx++] = arr2[idx2++];
            } else if (idx2 >= arr2.length) {
                arr[idx++] = arr1[idx1++];
            } else if (arr1[idx1] <= arr2[idx2]) {
                arr[idx++] = arr1[idx1++];
            } else {
                arr[idx++] = arr2[idx2++];
            }
        }
        return arr;
    }
}
