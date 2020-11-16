package com.atguigu.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author houjie
 * @version V1.0
 * @date 2020/11/10 22:10
 */
public class BubbleSort {

  public static int[] sort(int[] arr) {
    int[] copy = Arrays.copyOf(arr, arr.length);
    for (int i = 0; i < copy.length - 1; i++) {
      boolean flag = false; // 是否进行过交换
      for (int j = 0; j < copy.length - 1 - i; j++) {
        if (copy[j] > copy[j+1]) {
          flag = true;
          int temp = copy[j];
          copy[j] = copy[j+1];
          copy[j+1] = temp;
        }
      }

      if (!flag) {
        break;
      }
    }
    return copy;
  }
}
