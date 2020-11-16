package com.atguigu.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author houjie
 * @version V1.0
 * @date 2020/11/13 23:04
 */
public class QuickSort {

  public static int[] sort(int[] arr) {
    int[] copy = Arrays.copyOf(arr, arr.length);
    quickSort(copy, 0, copy.length - 1);
    return copy;
  }

  private static int[] quickSort(int[] arr, int left, int right) {
    if (left < right) {
      int pivot = partition(arr, left, right);
      quickSort(arr, left, pivot - 1);
      quickSort(arr, pivot + 1, right);
    }
    return arr;
  }

  private static int partition(int[] arr, int left, int right) {
    // 基准值
    int pivot = left;
    // 循环后基准值的位置
    int index = pivot + 1;
    for (int i = index; i <= right; i++) {
      if (arr[i] < arr[pivot]) {
        swap(arr, i, index);
        index++;
      }
    }
    if (pivot != index - 1) {
      swap(arr, pivot, index - 1);
    }
    return index - 1;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
