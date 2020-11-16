package com.atguigu.sort;

import java.util.Arrays;

/**
 * 插入排序
 * @author houjie
 * @version V1.0
 * @date 2020/11/12 0:02
 */
public class InsertSort {

  public static int[] sort(int[] arr) {
    int[] copy = Arrays.copyOf(arr, arr.length);
    for (int i = 1; i < copy.length; i++) {
      int insertValue = copy[i];
      int insertIndex = i - 1;
      while (insertIndex >= 0 && insertValue < copy[insertIndex]) {
        copy[insertIndex + 1] = copy[insertIndex];
        insertIndex--;
      }
      if (insertIndex + 1 != i) {
        copy[insertIndex + 1] = insertValue;
      }
    }
    return copy;
  }
}
