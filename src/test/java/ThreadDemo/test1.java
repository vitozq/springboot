package ThreadDemo;

import java.util.Arrays;

public class test1 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static  ListNode mergeKLists(ListNode[] lists) {

        if (lists == null) {
            return null;
        }
//        for (int i = 0; i < lists.length; i++) {
//            if (lists[i] == null) {
//                lists[i] = lists[lists.length - 1];
//                lists = Arrays.copyOf(lists, lists.length - 1);
//            }
//        }
        // for(int i= lists.length-1;i>0;i--){
        //     lists[i-1]=mergeList(lists[i],lists[i-1]);
        // }
        for (int i = 0; i < lists.length - 1; i++) {
            lists[i + 1] = mergeList(lists[i + 1], lists[i]);
        }
        return lists[lists.length - 1];
    }

    public static  ListNode mergeList(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }
        else if(l1==null){
            return l2;
        }
        else if(l2==null){
            return l1;
        }
        ListNode result = null;
        if (l1.val < l2.val) {
            result = l1;
            result.next = mergeList(l1.next, l2);
        } else {
            result = l2;
            result.next = mergeList(l2.next, l1);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[5];
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(8);
        ListNode l4 = new ListNode(41);
        ListNode l5 = new ListNode(2);

        lists[0]=l1;
        lists[1]=l2;
        lists[2]=l3;
        lists[3]=l4;
        lists[4]=l5;
        System.out.print(mergeKLists(lists));
    }
}
