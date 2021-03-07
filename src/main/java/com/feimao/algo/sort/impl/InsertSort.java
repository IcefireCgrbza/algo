package com.feimao.algo.sort.impl;

import com.feimao.algo.sort.Sort;

/**
 * @Author: feimao
 * @Date: 21-3-7 上午11:22
 */
public class InsertSort extends Sort {

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            for (int j = i - 1;; j--) {
                if (j < 0 || arr[j] < tmp) {
                    arr[j + 1] = tmp;
                    break;
                } else {
                    arr[j + 1] = arr[j];
                }
            }
        }
    }
}
