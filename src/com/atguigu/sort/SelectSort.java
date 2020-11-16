package com.atguigu.sort;

import java.util.Arrays;

/**
 * 选择排序
 * @author houjie
 * @version V1.0
 * @date 2020/11/11 23:17
 */
public class SelectSort {

  public static int[] sort(int[] arr) {
    int[] copy = Arrays.copyOf(arr, arr.length);
    for (int i = 0; i < copy.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < copy.length; j++) {
        if (copy[j] < copy[minIndex]) {
          minIndex = j;
        }
      }
      if (minIndex != i) {
        int min = copy[minIndex];
        copy[minIndex] = copy[i];
        copy[i] = min;
      }
    }
    return copy;
  }
}
