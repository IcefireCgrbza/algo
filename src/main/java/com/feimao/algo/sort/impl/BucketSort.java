package com.feimao.algo.sort.impl;

import com.feimao.algo.sort.Sort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: feimao
 * @Date: 21-3-6 下午3:10
 */
public class BucketSort extends Sort {

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

        int bucketCount = 5;
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new LinkedList<>());
        }

        for (int a : arr) {
            buckets.get((a - min) / (max - min) * (bucketCount - 1)).add(a);
        }

        int[] sorted = new int[arr.length];
        int start = 0;
        for (int i = 0; i < bucketCount; i++) {
            List<Integer> bucket = buckets.get(i);
            if (bucket.size() > 0) {
                Collections.sort(bucket);
                for (int j = 0; j < bucket.size(); j++) {
                    sorted[start++] = bucket.get(j);
                }
            }
        }
        System.arraycopy(sorted, 0, arr, 0, arr.length);
    }
}
