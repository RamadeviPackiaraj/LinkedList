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
class Rotate_LinkedList {
    public ListNode findNthNode(ListNode head,int k){
      int len=1;
    while(head!=null){
        if(len==k) return head;
        len++;
        head=head.next;
    }
    return head;
    }
    public ListNode rotateRight(ListNode head, int k) {
        int len=1;
        ListNode tail=head;
        while(tail!=null&&tail.next!=null){
            len++;
            tail=tail.next;
        }
        if(k%len==0) return head;
        k=k%len;
        tail.next=head;
        ListNode newLastNode=findNthNode(head,len-k);
        head=newLastNode.next;
        newLastNode.next=null;
        return head;
    }
}