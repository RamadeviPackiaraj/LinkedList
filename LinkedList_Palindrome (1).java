import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class LinkedList_Palindrome{
    public static Node Reverse(Node head){
        if(head==null||head.next==null){
            return head;
        }
        Node newHead=Reverse(head.next);
        Node front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
    
    public static boolean CheackPalindrome(Node head){
        Node slow=head;
        Node fast=head;
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node newHead=Reverse(slow.next);
        Node first=head;
        Node second=newHead;
        while(second.next!=null){
            if(first.data!=second.data){
                Reverse(newHead);
                return false;
            }
            first=first.next;
            second=second.next;
        }
        return true;
    }
    public static void main(String[] arge){
     Scanner sc=new Scanner(System.in);
     int n=sc.nextInt();
     Node head=null,tail=null;
     for(int i=0;i<n;i++){
         int data=sc.nextInt();
         Node newNode=new Node(data);
         if(head==null){
             head=newNode;
             tail=newNode;
         }
         else{
             tail.next=newNode;
             tail=newNode;
         }
     }
     System.out.println(CheackPalindrome(head));
    }
}