/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode curr = dummy;
        while(curr.next != null && curr.next.next != null){
            if(curr.next.val != curr.next.next.val){
                curr = curr.next;
            }else{
                ListNode temp = curr.next;
                while(temp.next != null && temp.next.val == curr.next.val){
                    temp = temp.next;
                }
                curr.next = temp.next;
            }
        }
        return dummy.next;
    }
}
