package math.random;

import java.util.Random;

/**
 * @Classname : LinkedListRandomNode
 * @Description : 382. 链表随机节点
 * https://leetcode.cn/problems/linked-list-random-node/
 * 水库算法：遍历一次链表，在遍历到第 m 个节点时，有 1/m 的概率选择这个节点覆盖掉之前的节点选择。
 * 水库算法随机性证明：
 *     对于长度为 n 的链表的第 m 个节点，最后被采样的充要条件是它被选择，且之后的节点都没有被选择。
 *     这种情况发生的概率为：1/m × m/m+1 × m+1/m+2 × · · · × n−1/n = 1/n 。因此每个点都有均等的概率被选择。
 * @Author : chentianyu
 * @Date 2022/10/16 23:54
 */


public class LinkedListRandomNode {
    private ListNode list;
    private Random random;

    public LinkedListRandomNode(ListNode head) {
        list = head;
        random = new Random();
    }

    public int getRandom() {
        int ans = 0, i = 1;
        for (ListNode cur = list; cur != null; cur = cur.next) {
            // ran ∈ [0, i)
            if (random.nextInt(i) == 0) {
                ans = cur.val;
            }
            i++;
        }
        return ans;
    }

    class ListNode { int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
