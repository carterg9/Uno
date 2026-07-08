//Assignment 1 - Carter Giesbrecht - 3184975
public class SinglyLinkedList<E>{

    private static class Node<E>{ //nested node class
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n)
        {
            element = e;
            next = n;
        }
        public E getElement()
        { return element;}
        public Node<E> getNext()
        { return next;}
        public void setNext(Node<E> n)
        {next = n;}
    } // end of nested node
    //instance variables of the SinglyLinkedList
    private Node<E> head = null;    //head node of the list
    private Node<E> tail = null;   // last node of the list
    private int size = 0;         // number of nodes in the list
    public SinglyLinkedList(){}  // constructs an initially empty list
    //access methods
    public int size(){return size;}
    public boolean isEmpty(){return size == 0;}
    public E first() {          // returns the first element
        if(isEmpty()) return null;
        return head.getElement();
    }
    public E last() {          // returns the last element
        if(isEmpty()) return null;
        return tail.getElement();
    }

    //update methods
    public void addFirst(E e) { //add element e to the front of list
        head = new Node<>(e,head);  //create and link a new node
        if(size == 0)
            tail = head;        //special case: new node becomes tail also
        size++;
    }
    public void addLast(E e) {      //adds element e to the end of list
        Node<E> newest = new Node<>(e, null);   //node will eventually be the tail
        if(isEmpty())
            head = newest;      //special case: previously empty list
        else
            tail.setNext(newest);   //new node after existing tail
        tail = newest;              // new node becomes the tail
        size++;
    }
    public E removeFirst() {    //removes and returns the first element
        if(isEmpty()) return null;  //nothing to remove
        E answer = head.getElement();
        head = head.getNext();      //will become null if list had only one node
        size--;
        if(size == 0)
            tail = null;        //special case as list is now empty
        return answer;
    }

    public String toString() //override toString
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = head; //set to head
        while(current != null){
            sb.append("(" + (current.getElement().toString()) + ")");
            if(current.getNext() != null) //continue if next value exists
                sb.append(", ");
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
