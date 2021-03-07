package com.feimao.algo.sort.impl;

import com.feimao.algo.sort.Sort;

/**
 * @Author: feimao
 * @Date: 21-3-6 上午11:24
 */
public class HeapSort extends Sort {

    @Override
    public void sort(int[] arr) {
        //构建最大堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            down(arr, arr.length, i);
        }
        //移除堆顶元素到数组尾部
        for (int len = arr.length - 1; len > 0; len--) {
            swap(arr, 0, len);
            down(arr, len, 0);
        }
    }

    /**
     * idx节点下沉
     */
    private void down(int[] arr, int len, int idx) {
        int parentIdx = idx;
        int childIdx = (parentIdx * 2) + 1;
        while (childIdx < len) {
            if (childIdx + 1 < len && arr[childIdx + 1] > arr[childIdx]) {
                //找最大的子节点
                childIdx++;
            }
            if (arr[parentIdx] >= arr[childIdx]) {
                //下沉结束
                return;
            }
            swap(arr, parentIdx, childIdx);
            parentIdx = childIdx;
            childIdx = (parentIdx * 2) + 1;
        }
    }
}
