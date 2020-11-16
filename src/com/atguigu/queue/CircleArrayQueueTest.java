package com.atguigu.queue;

import java.util.Scanner;

/**
 * @author houjie
 * @version V1.0
 * @date 2020/9/19 22:52
 */
public class CircleArrayQueueTest {

  public static void main(String[] args) {
    CircleArrayQueue queue = new CircleArrayQueue(3);
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
 * 环形队列
 */
class CircleArrayQueue {
  private int maxSize;
  private int front;
  private int rear;
  private int[] arr;

  public CircleArrayQueue(int maxSize) {
    this.maxSize = maxSize + 1;
    this.arr = new int[this.maxSize];
    this.front = 0; // 指向队列头部，分析出front是指向队列第一个数据
    this.rear = 0; // 指向队列尾部，最后一个数据的后一个位置
  }

  public boolean isFull() {
    // 保留一个空位
    return (rear + 1) % maxSize == front;
  }

  public boolean isEmpty() {
    return front == rear;
  }

  public void addQueue(int n) {
    if (isFull()) {
      System.out.println("队列满，不能加入数据");
      return;
    }
    arr[rear] = n;
    rear = (rear + 1) % maxSize;
  }

  public int getQueue() {
    if (isEmpty()) {
      throw new RuntimeException("队列空，不能取数据");
    }
    int value = arr[front];
    front = (front + 1) % maxSize;
    return value;
  }

  public void showQueue() {
    if (isEmpty()) {
      System.out.println("队列空，没有数据");
    }
    for (int i = front; i < front + size(); i++) {
      System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
    }
  }

  public int size() {
    return (rear + maxSize - front) % maxSize;
  }

  public int head() {
    if (isEmpty()) {
      throw new RuntimeException("队列空，没有头数据");
    }
    return arr[front];
  }
}
