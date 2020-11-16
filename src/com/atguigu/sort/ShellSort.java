package com.atguigu.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * @author houjie
 * @version V1.0
 * @date 2020/11/12 23:07
 */
public class ShellSort {

  /**
   * 交换法
   * @param arr
   * @return
   */
  public static int[] exchangeSort(int[] arr) {
    int[] copy = Arrays.copyOf(arr, arr.length);
    for (int gap = copy.length / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < copy.length; i++) {
        for (int j = i - gap; j >= 0; j -= gap) {
          if (copy[j] > copy[j + gap]) {
            int temp = copy[j];
            copy[j] = copy[j + gap];
            copy[j + gap] = temp;
          }
        }
      }
    }
    return copy;
  }

  /**
   * 移位法
   * @param arr
   * @return
   */
  public static int[] shiftSort(int[] arr) {
    int[] copy = Arrays.copyOf(arr, arr.length);
    for (int gap = copy.length / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < copy.length; i++) {
        int insertValue = copy[i];
        int insertIndex = i - gap;
        while (insertIndex >= 0 && insertValue < copy[insertIndex]) {
          copy[insertIndex + gap] = copy[insertIndex];
          insertIndex -= gap;
        }
        if (insertIndex + gap != i) {
          copy[insertIndex + gap] = insertValue;
        }
      }
    }
    return copy;
  }
}
