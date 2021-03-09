package com.feimao.algo;

/**
 * @Author: feimao
 * @Date: 21-3-8 下午8:08
 */
public class BinarySearch {

    public static int search(int[] arr, int tar) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == tar) {
                return mid;
            } else if (arr[mid] < tar) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
