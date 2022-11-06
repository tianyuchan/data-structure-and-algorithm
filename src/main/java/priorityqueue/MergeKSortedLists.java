package priorityqueue;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname : MergeKSortedLists
 * @Description : 23. 合并K个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 * @Author : chentianyu
 * @Date 2022/11/6 23:31
 */


public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(), tail = head;
        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(o1 -> o1.val));
        for (ListNode node : lists) {
            if (node != null) {
                q.offer(node);
            }
        }
        while (!q.isEmpty()) {
            tail.next = q.poll();
            tail = tail.next;
            if (tail.next != null) {
                q.offer(tail.next);
            }
        }
        return head.next;
    }


    private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
