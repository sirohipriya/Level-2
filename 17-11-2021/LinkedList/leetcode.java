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



//===================================================================== Mid of a node(even-> last of first half)==============================================================


public ListNode middleNode2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    


// =======================================================================234. Palindrome LinkedList=========================================================================



public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        ListNode mid = middleNode(head);
        ListNode nhead = reverseList(mid.next);
        
        while(nhead != null){
            if(head.val != nhead.val){
                return false;
            }
                head = head.next;
                nhead = nhead.next;
        }
        nhead = reverseList(nhead);
        mid.next = nhead;
        
        return true;
    }
