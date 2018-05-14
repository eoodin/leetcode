package eoodin.p002;

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode result = null;
        int carry = 0;
        ListNode cn = null;
        while (n1 != null || n2 != null || carry > 0) {
            int r = (n1 == null ? 0: n1.val) + (n2 == null ? 0 : n2.val) + carry;
            carry = r / 10;
            ListNode nl = new ListNode(r % 10);
            if(result == null)
               result = nl;
            if (cn != null)
                cn.next = nl;
            cn = nl;
            n1 = n1 == null ? null : n1.next; //TODO: either link rich end, link other sub link should be ok
            n2 = n2 == null ? null: n2.next;
        }

        return result;
    }

    private void printList(ListNode list) {
        ListNode n = list;
        while(n != null) {
            System.out.print(n.val);
            n = n.next;
        }
        System.out.println();
    }
}
