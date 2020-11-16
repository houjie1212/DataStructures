package com.atguigu.queue;

import java.util.Scanner;

/**
 * @author houjie
 * @version V1.0
 * @date 2020/9/13 11:51
 */
public class ArrayQueueTest {

  public static void main(String[] args) {
    ArrayQueue queue = new ArrayQueue(3);
    Scanner scanner = new Scanner(System.in);
    char input;
    boolean isLoop = true;
    while(isLoop) {
      System.out.println("s (show): 显示队列");
      System.out.println("e (exit): 退出程序");
      System.out.println("a (add): 添加数据");
      System.out.println("g (get): 取出数据");
      System.out.println("h (head): 查看头数据");
      input = scanner.next().charAt(0);

      switch (input) {
      case 's':
        queue.showQueue();
        break;
      case 'e':
        scanner.close();
        isLoop = false;
        System.out.println("程序退出");
        break;
      case 'a':
        System.out.println("输入一个数字");
        int num = scanner.nextInt();
        queue.addQueue(num);
        break;
      case 'g':
        try {
          int res = queue.getQueue();
          System.out.printf("取出的数据是%d\n", res);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
        break;
      case 'h':
        try {
          int res = queue.head();
          System.out.printf("队列头数据是%d\n", res);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
        break;
      default:
        break;
      }
    }
  }
}

/**
 * 队列
 */
class ArrayQueue {
  private int maxSize;
  private int front;
  private int rear;
  private int[] arr;

  public ArrayQueue(int maxSize) {
    this.maxSize = maxSize;
    this.arr = new int[maxSize];
    this.front = -1; // 指向队列头部，分析出front是指向队列头的前一个位置
    this.rear = -1; // 指向队列尾部，指向队列尾的数据(即就是队列最后一个数据)
  }

  public boolean isFull() {
    return rear == maxSize - 1;
  }

  public boolean isEmpty() {
    return front == rear;
  }

  public void addQueue(int n) {
    if (isFull()) {
      System.out.println("队列满，不能加入数据");
      return;
    }
    arr[++rear] = n;
  }

  public int getQueue() {
    if (isEmpty()) {
      throw new RuntimeException("队列空，不能取数据");
    }
    return arr[++front];
  }

  public void showQueue() {
    if (isEmpty()) {
      System.out.println("队列空，没有数据");
    }
    for (int i = front + 1; i <= rear; i++) {
      System.out.printf("arr[%d]=%d\n", i, arr[i]);
    }
  }

  public int head() {
    if (isEmpty()) {
      throw new RuntimeException("队列空，没有头数据");
    }
    return arr[front + 1];
  }
}