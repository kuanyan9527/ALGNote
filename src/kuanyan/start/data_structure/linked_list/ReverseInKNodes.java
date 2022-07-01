package kuanyan.start.data_structure.linked_list;

// K个节点的组内逆序调整
// 测试链接：https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseInKNodes {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 1. getGroupEnd 返回值为null，表示余下的节点不够k个，结束整个算法，反之继续向下执行
     * 2、reverse 反转start节点到end节点，返回反转后组内的头节点，记录lastStart = start
     * 3. lastStart.nex = reverse的返回值
     */
    static ListNode lastStart;
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode start = head;
        ListNode end = getGroupEnd(start, k);
        if (end == null) {
            return head;
        }
        head = reverse(start, end);
        start = lastStart.next;
        while ((end = getGroupEnd(start, k)) != null) {
            lastStart.next = reverse(start, end);
            start = lastStart.next;
        }

        return head;
    }

    public static ListNode getGroupEnd(ListNode start, int k) {
        ListNode end = start;
        while (--k != 0 && end != null) {
            end = end.next;
        }
        return end;
    }

    public static ListNode reverse(ListNode start, ListNode end) {
        ListNode pre = end.next;
        ListNode next;
        ListNode current = start;
        while (pre != end) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        lastStart = start;
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);
        ListNode eight = new ListNode(8);
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;

        head = reverseKGroup(head, 3);
        System.out.println(head);
    }
}
