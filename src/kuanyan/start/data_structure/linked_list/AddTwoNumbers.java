package kuanyan.start.data_structure.linked_list;

// 测试链接：https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 找到长链表/longer和短链表shorter，然后分三步走
     * 1。longer和shorter节点都存在
     * 2.只有loner存在
     * 3.longer也结束，处理最后一个进位
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode[] res = findLongerList(l1, l2);
        ListNode longer = res[0];
        ListNode shorter = res[1];
        ListNode lc = longer;
        ListNode sc = shorter;
        ListNode lastLc = lc;
        int carry = 0;
        while (sc != null) {
            int v1 = lc.val;
            int v2 = sc.val;
            lc.val = (v1 + v2 + carry) % 10;
            carry = (v1 + v2 + carry) / 10;
            lastLc = lc;
            lc = lc.next;
            sc = sc.next;
        }

        while (lc != null) {
            int v1 = lc.val;
            lc.val = (v1 + carry) % 10;
            carry = (v1 + carry) / 10;
            lastLc = lc;
            lc = lc.next;
        }

        if (carry != 0) {
            lastLc.next = new ListNode(carry);
        }

        return longer;
    }

    public static ListNode[] findLongerList(ListNode l1, ListNode l2) {
        ListNode[] sizeArray = new ListNode[2];
        ListNode c1 = l1;
        ListNode c2 = l2;
        while (true) {
            if ((c1 = c1.next) == null) {
                sizeArray[0] = l2;
                sizeArray[1] = l1;
                break;
            }
            if ((c2 = c2.next) == null) {
                sizeArray[0] = l1;
                sizeArray[1] = l2;
                break;
            }
        }
        // 0: 长链表
        // 1: 短链表
        return sizeArray;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode two = new ListNode(7);
        ListNode three = new ListNode(6);


        ListNode l2 = new ListNode(9);
        ListNode four = new ListNode(2);
        ListNode five = new ListNode(4);

        l1.next = two;
        two.next = three;

        l2.next = four;
        four.next = five;

        ListNode l = addTwoNumbers(l1, l2);
        System.out.println(l);
    }
}
