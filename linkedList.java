
public class LinkedListss {
    Node head;
    private int size;
    LinkedListss(){
        this.size=0;
    }
    class Node{
        String data;
        Node next;
Node(String data){
    this.data=data;
    this.next=null;
    size++;
}
    }
    public void addFirst(String data){
       Node newNode=new Node(data);
        if(head==null){
head=newNode;
return;
        }
       
        newNode.next= head;
        head = newNode;
        
    }
    public void addLast(String data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
                    }
        Node currNode=head;
        while(currNode.next!=null){
            currNode=currNode.next;
        }
        currNode.next=newNode;
    
    }
        public void printList(){
            if (head==null) {
                System.out.println("LIST IS EMPTY ");
                return;
            }
            Node currNode=head;
            while(currNode!=null){
                System.out.print(currNode.data+"-> ");
                currNode=currNode.next;
            }
           System.out.println("NULL ");
        }
        public void deleteFirst(){
                    if(head==null){
                System.out.println("the list is empty ");
                      return;  }
 size--;
                      head=head.next;
        }
    public void deleteLast(){
        
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        size--;
    if (head.next==null) {
        head=null;
        return;
    }
    Node secondLast=head;
    Node last=head.next;
    while(last.next!=null){
        last=last.next;
        secondLast=secondLast.next;
    }
    secondLast.next=null;
    }
    public int getSize(){
        return size;
    }
  public void reverseIterate(){
    if (head==null||head.next==null) {
        return;
    }
    Node prevNode=head;
    Node currNode=head.next;
    while (currNode!=null) {
        Node nextNode=currNode.next;
        currNode.next=prevNode;
        //update
        prevNode=currNode;
        currNode=nextNode;
    }
    head.next=null;
    head=prevNode;
  }
  public Node  reverseRecuursive(Node head){
    if (head==null||head.next==null) {
        return head;
    }
Node newHead =reverseRecuursive(head.next);
  head.next.next=head;
head.next=null;
return newHead;
}
//remove any node 
  public void removeNthFromEnd(int n) {
    if (head == null) {
        return;
    }
   
    int count = 0;
    Node temp = head;
    while (temp != null) {
        temp = temp.next;
        count++;
    }
   
    if (n > count) {
        System.out.println("Invalid position");
        return;
    }
   
    int position = count - n + 1;
   
    if (position == 1) {
        head = head.next;
        return;
    }
   
    Node prev = null;
    Node current = head;
    int currentPosition = 1;
    while (currentPosition < position) {
        prev = current;
        current = current.next;
        currentPosition++;
    }
   
    prev.next = current.next;
}
public Node findMiddle(Node head){
    Node hare=head;
    Node turtle=head;
    while (hare.next!=null&&hare.next.next!=null) {
        hare=hare.next.next;
turtle=turtle.next;
    }
    return turtle;
}
// find that linked list is palindrome or not 
public boolean isPalindrome(Node head){
    if (head==null||head.next==null) {
        return true;
    }
    Node middle =findMiddle(head);  //1st half end
  Node secondHalfStart=  reverseRecuursive(middle.next);
  Node firstHalfStart =head;
  while (secondHalfStart != null) {
    if (firstHalfStart.data!=secondHalfStart.data) {
        return false;
    }
    firstHalfStart=firstHalfStart.next;
    secondHalfStart=secondHalfStart.next;
  }
  return true;
}
//to find that a linked list has a cycle or not
 public boolean hasCycle(Node head){
    if (head==null) {
        return false;
    }
    //FLOYD'S METHOD
    Node hare=head;//fast
    Node turtle=head;//slow
while (hare!=null&&hare.next!=null) {
    hare=hare.next.next;
    turtle=turtle.next;
    if (hare==turtle) {
        return true;
    }
}
return false;
 }
    public static void main(String[] args) {
        LinkedListss list =new LinkedListss();
    
        list.addFirst("SWASTIK\t");
        list.addLast("TRIPATHI");
            list.printList();
    list.deleteFirst();
    list.printList();
list.addFirst("swtr");
list.addLast("SWTR");
list.deleteLast();
list.printList();
list.head=list.reverseRecuursive(list.head);
list.printList();
list.reverseIterate();
list.printList();
list.reverseRecuursive(list.head);
list.printList();
list.removeNthFromEnd(1);
System.out.println(" LINKED LIST IS PALINDROME "+list.isPalindrome(list.head));
System.out.println("linked LIST HAS A CYCLE " +list.hasCycle(list.head));
System.out.println(list.getSize());}
  } 
