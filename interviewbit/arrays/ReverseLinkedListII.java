import org.junit.Test;


public class ReverseLinkedListII {
  public ListNode reverseBetween(ListNode A, int B, int C) {

    ListNode start = A;

    if(start == null) return A;

    int index = 1;

    while(index < B-1) {
      start = start.next;
      index++;
    }

    ListNode first = start.next;
    ListNode current = start.next;
    ListNode nextOfCurrent = current != null ? current.next : null;
    ListNode following = nextOfCurrent != null ? nextOfCurrent.next:null;
    int indexOfCurrent = start != A ? B : B + 1;

    while(current != null && indexOfCurrent != C) {
      if(nextOfCurrent != null) nextOfCurrent.next = current;
      current = nextOfCurrent;
      nextOfCurrent = following;
      following = nextOfCurrent != null ? nextOfCurrent.next:null;
      indexOfCurrent++;
    }

    if(start != A) {
      start.next = current;
      if (first != null) {
        first.next = nextOfCurrent;
      }
    }else{
      start.next = null;
      first.next = start;
      A = current;
      start = current;
    }

    return A;
  }

  @Test
  public void test() {
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(2);
    a.next = b;
    a = reverseBetween(a, 1, 2);
    printList(a);
  }

  @Test
  public void single() {
    ListNode a = new ListNode(1);
    reverseBetween(a, 1, 1);
    printList(a);
  }

  @Test
  public void multiple() {
    ListNode start = new ListNode(1);
    ListNode first = start;
    while(start.val < 21) {
      ListNode next = new ListNode(start.val + 1);
      start.next = next;
      start = next;
    }
    reverseBetween(first, 1, 21);
    printList(first);
  }

  public void printList(ListNode a) {
    while(a != null) {
      System.out.print(a.val + " ");
      a = a.next;
    }
  }
}
