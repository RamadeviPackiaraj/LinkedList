import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class Merge_Two_Sorted_LinkedList{
public static Node Merge(Node list1,Node list2){
    Node t1=list1;
    Node t2=list2;
    Node dummy=new Node(-1);
    Node temp=dummy;
    while(t1!=null&&t2!=null){
        if(t1.data<t2.data){
            temp.next=t1;
            temp=t1;
            t1=t1.next;
        }else{
            temp.next=t2;
            temp=t2;
            t2=t2.next;
        }
    }
    if(t1!=null){
        temp.next=t1;
    }
    else{
        temp.next=t2;
    }
    return dummy.next;
}
public static Node createList(int[] arr){
    Node dummy=new Node(-1);//fixed starting point
    Node curr=dummy;//moving the point
    for(int n:arr){
        curr.next=new Node(n);
        curr=curr.next;
    }
    return dummy.next;
}
public static void PrintList(Node head){
    while(head!=null){
        System.out.print(head.data+" ");
        head=head.next;
    }
}
public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int m=sc.nextInt();
    int[] arr1=new int[m];
    for(int i=0;i<m;i++) arr1[i]=sc.nextInt();
      int n=sc.nextInt();

    int[] arr2=new int[n];
    for(int i=0;i<n;i++) arr2[i]=sc.nextInt();
    Node list1=createList(arr1);
    Node list2=createList(arr2);
    Node merge= Merge(list1,list2);
    PrintList(merge);
}
}//TC= O(n) SC=O(1)