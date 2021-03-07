package com.feimao.algo.sort.impl;

import com.feimao.algo.sort.Sort;

/**
 * @Author: feimao
 * @Date: 21-3-7 上午11:31
 */
public class ShellSort extends Sort {

    @Override
    public void sort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < arr.length; i++) {
                int tmp = arr[i];
                for (int j = i - gap;; j -= gap) {
                    if (j < 0 || arr[j] < tmp) {
                        arr[j + gap] = tmp;
                        break;
                    } else {
                        arr[j + gap] = arr[j];
                    }
                }
            }
        }
    }
}
