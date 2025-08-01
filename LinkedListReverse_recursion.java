import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class LinkedListReverse{
    public static Node reverseList(Node head) {
    if(head==null||head.next==null){
        return head;
    }
    Node newHead=reverseList(head.next);
    Node front=head.next;
    front.next=head;
    head.next=null;
    return newHead;
}
    public static void PrintList(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
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
        head=reverseList(head);
        PrintList(head);
    }
}