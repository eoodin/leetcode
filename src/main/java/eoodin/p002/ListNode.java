package eoodin.p002;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode build(int... nums) {
        if (nums.length == 0)
            return null;

        ListNode head = new ListNode(nums[0]);
        ListNode n = head;
        for (int i = 1; i < nums.length; i++) {
            n.next = new ListNode(nums[i]);
            n = n.next;
        }
        return head;
    }

}
