package com.atguigu.linkedlist;

/**
 * @author houjie
 * @version V1.0
 * @date 2020/9/20 22:20
 */
public class SingleLinkedListTest {
  public static void main(String[] args) {
    SingleHeroNode hero1 = new SingleHeroNode(1, "宋江", "及时雨");
    SingleHeroNode hero2 = new SingleHeroNode(2, "卢俊义", "玉麒麟");
    SingleHeroNode hero3 = new SingleHeroNode(3, "吴用", "智多星");
    SingleHeroNode hero4 = new SingleHeroNode(4, "林冲", "豹子头");

    SingleLinkedList heros1 = new SingleLinkedList();
    heros1.add(hero1);
    heros1.add(hero4);
    heros1.add(hero2);
    heros1.add(hero3);
    heros1.list();

    System.out.println("-------->");
    SingleLinkedList heros2 = new SingleLinkedList();
    heros2.addByNo(hero1);
    heros2.addByNo(hero4);
    heros2.addByNo(hero2);
    heros2.addByNo(hero3);
    heros2.list();

    System.out.println("-------->");
    heros2.update(new SingleHeroNode(2, "hello", "world"));
    heros2.list();

    System.out.println("-------->");
    heros2.delete(1);
    heros2.list();

    System.out.println("-------->");
    heros2.delete(4);
    heros2.list();

    System.out.println("-------->");
    heros2.delete(2);
    heros2.delete(3);
    heros2.list();

    System.out.println("-------->heros1反转前");
    heros1.list();
    System.out.println("-------->heros1反转后");
    heros1.reverse();
    heros1.list();
  }
}

class SingleLinkedList {
  private SingleHeroNode head = new SingleHeroNode(0, null, null);

  public void add(SingleHeroNode heroNode) {
    SingleHeroNode temp = head;
    while (true) {
      if (temp.next == null) {
        break;
      }
      temp = temp.next;
    }
    temp.next = heroNode;
  }

  public void list() {
    if (head.next == null) {
      System.out.println("链表为空");
      return;
    }
    SingleHeroNode temp = head.next;
    while (true) {
      if (temp == null) {
        break;
      }
      System.out.println(temp.toString());
      temp = temp.next;
    }
  }

  public void addByNo(SingleHeroNode heroNode) {
    SingleHeroNode temp = head;
    boolean flag = false; // 新英雄编号是否已存在
    while (true) {
      if (temp.next == null) { // 查到链表尾部
        break;
      }
      if (temp.next.no > heroNode.no) { // 找到新英雄插入的位置
        break;
      }
      if (temp.next.no == heroNode.no) { // 新英雄编号在链表中已存在
        flag = true;
        break;
      }
      temp = temp.next;
    }
    if (flag) {
      System.out.printf("英雄编号%d已存在", heroNode.no);
    } else {
      heroNode.next = temp.next;
      temp.next = heroNode;
    }
  }

  public void update(SingleHeroNode newHeroNode) {
    if (head.next == null) {
      System.out.println("链表为空");
      return;
    }
    SingleHeroNode temp = head.next;
    boolean flag = false;
    while (true) {
      if (temp == null) {
        break;
      }
      if (temp.no == newHeroNode.no) {
        flag = true;
        break;
      }
      temp = temp.next;
    }
    if (flag) {
      temp.name = newHeroNode.name;
      temp.nickname = newHeroNode.nickname;
    } else {
      System.out.printf("没有找到编号%d的节点\n", newHeroNode.no);
    }
  }

  public void delete(int no) {
    SingleHeroNode temp = head;
    boolean flag = false;
    while (true) {
      if (temp.next == null) {
        break;
      }
      if (temp.next.no == no) {
        flag = true;
        break;
      }
      temp = temp.next;
    }
    if (flag) {
      temp.next = temp.next.next;
    } else {
      System.out.printf("没有找到编号%d的节点\n", no);
    }
  }

  // 反转
  public void reverse() {
    if (head.next == null || head.next.next == null) {
      // 链表为空或只有一个节点
      return;
    }
    SingleHeroNode cur = head.next;
    SingleHeroNode next = null;
    SingleHeroNode reverseHead = new SingleHeroNode(0, "", "");
    while (cur != null) {
      next = cur.next;
      cur.next = reverseHead.next;
      reverseHead.next = cur;
      cur = next;
    }
    head = reverseHead;
  }
}

class SingleHeroNode {
  public int no;
  public String name;
  public String nickname;
  public SingleHeroNode next;

  public SingleHeroNode(int no, String name, String nickname) {
    this.no = no;
    this.name = name;
    this.nickname = nickname;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("HeroNode{");
    sb.append("no=").append(no);
    sb.append(", name='").append(name).append('\'');
    sb.append(", nickname='").append(nickname).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
