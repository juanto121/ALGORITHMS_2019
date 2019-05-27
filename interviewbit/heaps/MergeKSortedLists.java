import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
  public ListNode mergeKLists(ArrayList<ListNode> a) {
    int k = a.size();
    ListNode result;

    Comparator<ListNode> listNodeComp = new Comparator<ListNode>() {
      @Override
      public int compare(ListNode la, ListNode lb) {
        if(la != null && lb != null) return la.val-lb.val;
        if(la == null) return -1;
        else return 1;
      }
    };

    PriorityQueue<ListNode> q = new PriorityQueue<>(listNodeComp);
    for(int i = 0; i < k; i++) {
      ListNode list = a.get(i);
      q.add(list);
    }

    ListNode head = q.poll();
    result = new ListNode(head.val);
    ListNode root = result;

    while(head != null ) {
      if(head.next != null) q.add(head.next);
      head = q.poll();
      result.next = head;
      result = result.next;
    }

    return root;
  }

  @Test
  public void simple() {
    ListNode a = new ListNode(1);
    a.next = new ListNode(6);
    ArrayList<ListNode> list = new ArrayList<ListNode>();
    list.add(a);
    ListNode root =mergeKLists(list);

    while(root != null) {
      System.out.print(root.val + " -> ");
      root = root.next;
    }
  }
}


class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }

  @Override
  public String toString() {
    return String.valueOf(val);
  }
}