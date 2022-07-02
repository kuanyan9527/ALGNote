package kuanyan.start.data_structure.linked_list;

// 测试链接：https://leetcode.com/problems/merge-two-sorted-lists
public class MergeTwoSortedLinkedList {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode ans;
        ListNode c1 = list1;
        ListNode c2 = list2;
        if (c1.val <= c2.val) {
            ans = c1;
            c1 = c1.next;
        } else {
            ans = c2;
            c2 = c2.next;
        }
        ListNode last = ans;
        while (true) {
            if (c1 == null) {
                last.next = c2;
                break;
            }
            if (c2 == null) {
                last.next = c1;
                break;
            }
            if (c1.val <= c2.val) {
                last.next = c1;
                c1 = c1.next;
            } else {
                last.next = c2;
                c2 = c2.next;
            }
            last = last.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(4);

        ListNode l2 = new ListNode(1);
        ListNode four = new ListNode(3);
        ListNode five = new ListNode(4);

        l1.next = two;
        two.next = three;

        l2.next = four;
        four.next = five;

        ListNode ans = mergeTwoLists(l1, l2);
        System.out.println(ans);
    }
}
