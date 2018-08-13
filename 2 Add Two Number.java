/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        ListNode l1_back = l1;
        ListNode l2_back = l2;
        while(l1_back != null && l2_back != null){
            int val = l1_back.val + l2_back.val + (carry ? 1:0);
            if(carry = val >= 10)
                val -= 10;
            
            l1_back.val = val;
            if(l1_back.next == null && l2_back.next == null){
                if(carry) l1_back.next = new ListNode(1);
                return l1;
            }
            if(l1_back.next == null){
                l1_back.next = new ListNode(0);
            }
            if(l2_back.next == null){
                l2_back.next = new ListNode(0);
            }
            l1_back = l1_back.next;
            l2_back = l2_back.next;
        }
        return null;
    }
}
