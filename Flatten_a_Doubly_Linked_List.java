/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Flatten_a_Doubly_Linked_List {
    private Node flatten_res(Node head){
        Node curr=head,tail=head;
        while(curr!=null){
            Node child=curr.child;
            Node next=curr.next;
            if(child!=null){
                Node _tail=flatten_res(child);
                _tail.next=next;
                if(next!=null)  next.prev=_tail;
                curr.next=child;
                child.prev=curr;
                curr.child=null;
                curr=tail;
            }
            else
                curr=next;
                if(curr!=null)
                tail=curr;        
        }
        return tail;
    }
    public Node flatten(Node head) {
     if(head!=null)
       flatten_res(head); 
     return head;  
    }
}