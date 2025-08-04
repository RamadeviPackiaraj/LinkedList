import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class DelNode_From_end_LL{
public static Node DeleteNode(Node head,int n){
    Node slow=head;
    Node fast=head;
    for(int i=0;i<n;i++){
        fast=fast.next;
    }
    if(fast==null){
        return head.next;
    }
    while(fast.next!=null){
        slow=slow.next;
        fast=fast.next;
    }
    slow.next=slow.next.next;
    return head;
}
public static void PrintList(Node head){
    while(head!=null){
        System.out.print(head.data+" ");
        head=head.next;
    }
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
    int k=sc.nextInt();
    head=DeleteNode(head,k);
    PrintList(head);
}
}//TC= O(n) SC=O(1)