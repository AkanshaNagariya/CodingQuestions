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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode anshead = ans;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                anshead.next = list1;
                list1 = list1.next;
                anshead = anshead.next;
            } else {
                anshead.next = list2;
                list2 = list2.next;
                anshead = anshead.next;
            }
        }
        if(list1 != null) anshead.next = list1;
        if(list2 != null) anshead.next = list2;
        return ans.next;
    }
}