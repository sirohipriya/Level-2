// ========================================================================876. Middle of a Node===============================================================================



class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}



// ==============================================================206. Reverse Linked List=====================================================================================



class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode temp = curr.next;
        
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
