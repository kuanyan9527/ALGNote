package kuanyan.start.comparator;

import java.util.Comparator;
import java.util.PriorityQueue;

// 合并k个升序队列
// 测试链接：https://leetcode.com/problems/merge-k-sorted-lists/submissions/
public class MergeQueue {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    public static class ValComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new ValComparator());
        for(int i = 0, len = lists.length; i < len; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }

        if (queue.size() == 0) {
            return null;
        }

        ListNode head;
        ListNode cur = queue.poll();
        head = cur;
        ListNode last = cur;
        if (cur.next != null) {
            queue.add(cur.next);
        }
        while (queue.size() != 0) {
            cur = queue.poll();
            last.next = cur;
            if (cur.next != null) {
                queue.add(cur.next);
            }
            last = cur;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(2);
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(7);
        ListNode l4 = new ListNode(9);
        h1.setNext(l1);
        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(l4);

        ListNode h2 = new ListNode(3);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(10);
        ListNode l7 = new ListNode(13);
        h2.setNext(l5);
        l5.setNext(l6);
        l6.setNext(l7);

        ListNode h = mergeKLists(new ListNode[] { h1, h2 });
        System.out.println(h);
    }
}
