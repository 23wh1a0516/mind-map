import java.util.*;
class LinkedList {

    // Node definition for singly linked list
    static class SLLNode {
        int data;
        SLLNode next;
        SLLNode(int d) {
            data = d;
            next = null;
        }
    }

    // Reverse a linked list
    SLLNode reverseList(SLLNode h) {
        if (h == null) return null;
        SLLNode prev = null;
        SLLNode curr = h;
        SLLNode nxt = h;
        while (nxt != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }

    // Merge two sorted linked lists
    public SLLNode mergeTwoSortedLists(SLLNode A, SLLNode B) {
        if (A == null) return B;
        if (B == null) return A;
        SLLNode ptr;
        if (A.data <= B.data) {
            ptr = A;
            A = A.next;
        } else {
            ptr = B;
            B = B.next;
        }
        SLLNode temp = ptr;
        while (A != null && B != null) {
            if (A.data <= B.data) {
                temp.next = A;
                A = A.next;
            } else {
                temp.next = B;
                B = B.next;
            }
            temp = temp.next;
        }
        if (A == null) temp.next = B;
        else temp.next = A;
        return ptr;
    }

    // Detect if a cycle exists in linked list
    public boolean hasCycle(SLLNode head) {
        if (head == null) return false;
        SLLNode slow = head;
        SLLNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // Check if linked list is palindrome
    public boolean isPalindromic(SLLNode A) {
        if (A == null) return true;
        SLLNode m = middle(A);
        SLLNode h2 = m.next;
        m.next = null;
        h2 = reverse(h2);
        SLLNode h = A;
        while (h != null && h2 != null) {
            if (h.data != h2.data) return false;
            h = h.next;
            h2 = h2.next;
        }
        return true;
    }

    // Find middle node of linked list
    public SLLNode middle(SLLNode A) {
        SLLNode slow = A;
        SLLNode fast = A;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Reverse linked list helper
    public SLLNode reverse(SLLNode h2) {
        SLLNode prev = null;
        SLLNode curr = h2;
        SLLNode next = h2;
        while (next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Find starting node of cycle in linked list
    public SLLNode cycleStartNode(SLLNode A) {
        if (A == null) return null;
        SLLNode slow = A;
        SLLNode fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = A;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
