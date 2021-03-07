package com.feimao.algo.sort.impl;

import com.feimao.algo.sort.Sort;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: feimao
 * @Date: 21-3-6 下午3:31
 */
public class RadixSort extends Sort {

    @Override
    public void sort(int[] arr) {
        if (arr.length < 1) {
            return;
        }

        int max = arr[0];

        for (int a : arr) {
            max = max < a ? a : max;
        }

        int mod = 10;
        int dev = 1;
        do {
            List<List<Integer>> acc = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                acc.add(new LinkedList<>());
            }

            for (int a : arr) {
                acc.get((a % mod) / dev).add(a);
            }

            int[] sorted = new int[arr.length];
            int idx = 0;
            for (int i = 0; i < 10; i++) {
                List<Integer> ac = acc.get(i);
                for (int j = 0; j < ac.size(); j++) {
                    sorted[idx++] = ac.get(j);
                }
            }

            System.arraycopy(sorted, 0, arr, 0, arr.length);

            mod *= 10;
            dev *= 10;
        } while (max > mod);
    }
}
