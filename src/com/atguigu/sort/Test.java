package com.atguigu.sort;

import java.time.Duration;
import java.util.Random;

/**
 * @author houjie
 * @version V1.0
 * @date 2020/11/12 22:50
 */
public class Test {
  public static void main(String[] args) {
    Random random = new Random();
    int arr[] = new int[1000000];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = random.nextInt(arr.length * 10);
    }

    //    System.out.println(Arrays.toString(arr));
    System.out.println("============");

    // 冒泡
    System.out.println("冒泡排序：");
    long startBubble = System.currentTimeMillis();
    int[] bubbleSort = BubbleSort.sort(arr);
    //    System.out.println(Arrays.toString(bubbleSort));
    long endBubble = System.currentTimeMillis();
    System.out.println(Duration.ofMillis(endBubble - startBubble));
    System.out.println("------------");

    // 选择
    System.out.println("选择排序：");
    long startSelect = System.currentTimeMillis();
    int[] selectSort = SelectSort.sort(arr);
    //    System.out.println(Arrays.toString(selectSort));
    long endSelect = System.currentTimeMillis();
    System.out.println(Duration.ofMillis(endSelect - startSelect));
    System.out.println("------------");

    // 插入
    System.out.println("插入排序：");
    long startInsert = System.currentTimeMillis();
    int[] insertSort = InsertSort.sort(arr);
    //        System.out.println(Arrays.toString(insertSort));
    long endInsert = System.currentTimeMillis();
    System.out.println(Duration.ofMillis(endInsert - startInsert));
    System.out.println("------------");

    // 希尔-交换
    System.out.println("希尔-交换排序：");
    long startShellExchange = System.currentTimeMillis();
    int[] shellExchangeSort = ShellSort.exchangeSort(arr);
    //        System.out.println(Arrays.toString(shellExchangeSort));
    long endShellExchange = System.currentTimeMillis();
    System.out.println(Duration.ofMillis(endShellExchange - startShellExchange));
    System.out.println("------------");

    // 希尔-移位
    System.out.println("希尔-移位排序：");
    long startShellShift = System.currentTimeMillis();
    int[] shellShiftSort = ShellSort.shiftSort(arr);
    //    System.out.println(Arrays.toString(shellShiftSort));
    long endShellShift = System.currentTimeMillis();
    System.out.println(Duration.ofMillis(endShellShift - startShellShift));
    System.out.println("------------");

    // 快速
    System.out.println("快速排序：");
    long startQuick = System.currentTimeMillis();
    int[] quickSort = QuickSort.sort(arr);
    //    System.out.println(Arrays.toString(quickSort));
    long endQuick = System.currentTimeMillis();
    System.out.println(Duration.ofMillis(endQuick - startQuick));
    System.out.println("------------");
  }
}
