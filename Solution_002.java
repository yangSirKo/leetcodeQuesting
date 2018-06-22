package com.ccyang;

/**
	给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
	你可以假设除了数字 0 之外，这两个数字都不会以零开头。
	
	示例：
	输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
	输出：7 -> 0 -> 8
	原因：342 + 465 = 807
*/

// Definition for singly-linked list.
class ListNode {
   int val;
   ListNode next;
   ListNode(int x) { val = x; }
}

public class Solution_002 {
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(-1);
		ListNode p = head;
		// 创建链表1  1->9->9->9->9->9->9->9->9->9
		ListNode l1 = new ListNode(1);
		p.next = l1;
		p = l1;
		for(int i=0; i<=9; i++){
			ListNode node = new ListNode(9);
			p.next = node;
			p = node;
		}
		// 创建链表2  9
		ListNode l2 = new ListNode(9);
		// 执行相加逻辑
		ListNode node = addTwoNumbers(l1, l2);
		// 打印结果
		while(node!=null){
			System.out.println(node.val);
			node = node.next;
		}
	}

	// 正解
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	// 元素之和是否大于10， 大于10 需要进位
        boolean flag = false;
        ListNode node1 = l1;   // node1 指向链表l1 当前节点位置
        ListNode node2 = l2;   // node2 指向链表l2 当前节点位置
        ListNode head = new ListNode(-1);  // 创建新链表头结点
        ListNode p = head;   // 指向新链表头结点
        
        // 两个链表都没有遍历结束，循环不停止
        while(node1 != null || node2 != null){
            int n = 0;
            if(node1 != null && node2 != null){
            	n = node1.val + node2.val;
                node1 = node1.next;
                node2 = node2.next;
            }
            else if(node1 != null){
            	n = node1.val;
                node1 = node1.next;
            }
            else if(node2 != null){
            	n = node2.val;
                node2 = node2.next;
            }
            // 上一次循环是否有进位
            if(flag){
                n++;
                flag = false;
            }
            // 是否需要进位
            if(n >= 10){
                n -= 10;
                flag = true;
            }
                        
            // 链表中添加新节点
            ListNode node = new ListNode(n);
            p.next = node;
            p = node;
        }
        // 遍历完成后是否有进位
        if(flag){
        	ListNode node = new ListNode(1);
            p.next = node;
        }
        return head.next;
    }
    
    // 该算法先将链表转化为整数，然后两个整数相加，在转化为新链表。整数会出现溢出问题。
    // 该算法不能解决整型越界问题
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        
        int num1 = 0;
        int num2 = 0;
        
        // l1 转换为整数
        int flag = 1;
        while(l1 != null){
            num1 += l1.val * flag;
            flag *= 10;
            l1 = l1.next;
        }      
        //  l2 转换为整数
        flag = 1;
        while(l2 != null){
            num2 += l2.val * flag;
            flag *= 10;
            l2 = l2.next;
        }   
        int num = num1 + num2;        
        
        // 整数转换为链表3   整数807  --> 链表708
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while(true){
            int n = num % 10;
            System.out.println(n);
            num = num / 10;
            ListNode node = new ListNode((int)n);
            p.next = node;
            p = node;
            if(num == 0){
                break;
            }
        }
        return head.next;
    }
}
