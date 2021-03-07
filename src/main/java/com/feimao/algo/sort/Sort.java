package com.feimao.algo.sort;

/**
 * @Author: feimao
 * @Date: 21-2-27 上午9:16
 */
public abstract class Sort {

    public abstract void sort(int[] arr);

    protected void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
