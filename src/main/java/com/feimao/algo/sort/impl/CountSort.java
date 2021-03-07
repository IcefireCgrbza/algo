package com.feimao.algo.sort.impl;

import com.feimao.algo.sort.Sort;

/**
 * @Author: feimao
 * @Date: 21-3-6 下午2:49
 */
public class CountSort extends Sort {

    @Override
    public void sort(int[] arr) {
        if (arr.length < 1) {
            return;
        }

        int min = arr[0], max = arr[0];

        for (int a : arr) {
            min = min > a ? a : min;
            max = max < a ? a : max;
        }

        //计数
        int countLen = max - min + 1;
        int[] count = new int[countLen];
        for (int a : arr) {
            count[a - min]++;
        }

        //acc数组的第i位表示i这个数在sorted中的最后位置，目的是使arr中相同数值具有区分度（不需要区分可省略该步骤）
        int[] acc = new int[countLen];
        for (int i = 0; i < countLen; i++) {
            acc[i] = i == 0 ? count[i] : (acc[i - 1] + count[i]);
        }

        int[] sorted = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sorted[--acc[arr[i] - min]] = arr[i];
        }
        System.arraycopy(sorted, 0, arr, 0, arr.length);
    }
}
