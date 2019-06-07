import org.junit.Test;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        SumResult temp = sum(l1, l2, carry);
        ListNode result = temp.list;
        carry = temp.carry;
        ListNode resultHead = result;
        l1 = next(l1); l2 = next(l2);

        while(l1 != null || l2 != null) {
            temp = sum(l1,l2,carry);
            carry = temp.carry;
            result.next = temp.list;
            result = result.next;
            l1 = next(l1); l2 = next(l2);
        }
        if(carry != 0) result.next = new ListNode(carry);
        return resultHead;
    }

    private SumResult sum(ListNode l1, ListNode l2, int carry) {
        int first = getNum(l1);
        int second = getNum(l2);

        int sum = carry + first + second;
        carry = sum / 10;
        sum = sum % 10;

        return new SumResult(new ListNode(sum), carry);
    }

    public ListNode next(ListNode l) {
        if( l == null ) return l;
        else return l.next;
    }

    public int getNum(ListNode l) {
        if(l == null) return 0;
        else return l.val;
    }

    class SumResult {
        ListNode list;
        int carry = 0;
        public SumResult(ListNode l, int c) {list = l; carry = c;}
    }

    public String printListNode(ListNode l) {
        StringBuilder stb = new StringBuilder();
        while(l != null) {
            stb.append(l.val + " ");
            l = l.next;
        }
        return stb.toString();
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(printListNode(addTwoNumbers(l1,l2)));
    }

    @Test
    public void testOverflow() {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        System.out.println(printListNode(addTwoNumbers(l1,l2)));
    }

    @Test
    public void testSimple() {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        System.out.println(printListNode(addTwoNumbers(l1,l2)));
    }

    @Test
    public void testSimpleWithZero() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        System.out.println(printListNode(addTwoNumbers(l1,l2)));
    }

    @Test
    public void testSimpleWithNull() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = null;
        System.out.println(printListNode(addTwoNumbers(l1,l2)));
    }


}


