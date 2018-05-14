package eoodin.p002;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddTwoNumberTest {

    private AddTwoNumber solution;

    @Before
    public void setup() {
        solution = new AddTwoNumber();
    }

    @Test
    public void test1() {
        ListNode l1 = ListNode.build(2, 4, 3);
        ListNode l2 = ListNode.build(5, 6, 4);
        ListNode result = solution.addTwoNumbers(l1, l2);

        assertEqual(ListNode.build(7, 0, 8), result);
    }

    @Test
    public void test2() {
        ListNode l1 = ListNode.build(5);
        ListNode l2 = ListNode.build(5);
        ListNode result = solution.addTwoNumbers(l1, l2);

        assertEqual(ListNode.build(0, 1), result);
    }

    @Test
    public void test3() {
        ListNode l1 = ListNode.build(1, 8);
        ListNode l2 = ListNode.build(0);
        ListNode result = solution.addTwoNumbers(l1, l2);

        assertEqual(ListNode.build(1, 8), result);
    }

    private void assertEqual(ListNode l1, ListNode l2) {
        while(l1 != null && l2 != null) {
            assertEquals(l1.val, l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        assertEquals(l1, l2);
    }
}
