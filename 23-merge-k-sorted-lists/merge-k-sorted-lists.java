/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
                PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Step 1: Add the head of each list to the priority queue
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        // Step 2: Use a dummy node to build the result list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            // Get the node with the smallest value
            ListNode node = pq.poll();
            tail.next = node;
            tail = tail.next;

            // If there are more nodes in this list, add the next node to the queue
            if (node.next != null) {
                pq.add(node.next);
            }
        }

        return dummy.next;
    }
}