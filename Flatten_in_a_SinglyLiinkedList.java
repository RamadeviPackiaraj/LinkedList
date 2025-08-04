/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
      if(head==null||head.next==null) return head;
      Node mergehead=flatten(head.next);
      head=merge(head,mergehead);
      return head;
    }
    public Node merge(Node list1,Node list2){
        Node dummy=new Node(-1);
        Node res=dummy;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                res.child=list1;
                res=list1;
                list1=list1.child;
            }else{
                res.child=list2;
                res=list2;
                list2=list2.child;
            }
            res.next=null;
        }
        if(list1!=null){
            res.child=list1;
        }
        else{
            res.child=list2;
        }
        if(dummy.child!=null) dummy.child.next=null;
        return dummy.child;
    }
}