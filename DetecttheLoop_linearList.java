import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
    public class DetecttheLoop{
        public static boolean Detect(Node head){
            Node slow=head;
            Node fast=head;
            while(fast!=null&&fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
                if(slow==fast){
                    return true;
                }
            }
            return false;
        }
    public static void main(String[] args)
{
     Scanner sc=new Scanner(System.in);
     int n=sc.nextInt();
     Node head=null,tail=null;
     for(int i=0;i<n;i++){
         int data=sc.nextInt();
         Node newnode=new Node(data);
             if(head==null){
                 head=newnode;
                 tail=newnode;
             }else{
                 tail.next=newnode;
                 tail=newnode;
             }
     }
     boolean res=Detect(head);
     System.out.println(res);
}    
}