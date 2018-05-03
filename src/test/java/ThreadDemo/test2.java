package ThreadDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class test2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        ListNode p =head;
        ListNode newNode= null;
        List<Integer> list =new ArrayList<Integer>();
        while(p!=null){
            list.add(p.val);
            ListNode tmp =p.next;
            p.next=newNode;
            newNode= p;
            p=tmp;
        }
        boolean flag= true;
        int i=0;
        while(newNode.next!=null){
            if(newNode.val!=list.get(i++)){
                flag =false;
            }
            newNode= newNode.next;
        }
        return flag;
    }

    public static void main(String []args){
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        System.out.print("是否为回文数"+new test2().isPalindrome(l1));
    }
}
