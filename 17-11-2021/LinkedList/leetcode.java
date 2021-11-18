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
        
        ListNode mid = middleNode2(head);
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


//==========================================================================143. Reorder List===============================================================================



public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        ListNode mid = middleNode2(head);
        ListNode nhead = mid.next;
        mid.next = null;
        
        nhead = reverseList(nhead);
        
        ListNode c1 = head;
        ListNode c2 = nhead;
        while(c2 != null){
            ListNode f1 = c1.next;
            ListNode f2 = c2.next;
            
            c1.next = c2;
            c2.next = f1;
            
            c1 = f1;
            c2 = f2;
            
        }
    
    
    //===================================================================
