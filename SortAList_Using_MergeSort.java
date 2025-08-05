import java.util.Scanner;
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}
public class SortAList_Using_MergeSort {
    public static ListNode findMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static ListNode merge(ListNode list1,ListNode list2){
        ListNode l1=list1;
        ListNode l2=list2;
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                temp.next=l1;
                l1=l1.next;              
            }else{
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        } 
        if(l1!=null){
            temp.next=l1;
        }else{
            temp.next=l2;
        }
        return dummy.next;
    }
    public static ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode middle=findMiddle(head);
        ListNode rightHead=middle.next;
         middle.next = null;
        ListNode leftSort=sortList(head);
        ListNode rightSort=sortList(rightHead);
        return merge(leftSort,rightSort);
    }
    public static void printList(ListNode head) {
    ListNode current = head;
    while(current != null) {
        System.out.print(current.val + " ");
        current = current.next;
    }
    System.out.println();
}
 public static void main(String[] arge){
     Scanner sc=new Scanner(System.in);
     int n=sc.nextInt();
     ListNode head=null,tail=null;
     for(int i=0;i<n;i++){
         int data=sc.nextInt();
         ListNode newNode=new ListNode(data);
         if(head==null){
             head=newNode;
             tail=newNode;
         }
         else{
             tail.next=newNode;
             tail=newNode;
         }
     }
     printList((sortList(head)));
    }
}