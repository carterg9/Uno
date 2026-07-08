// Assignment 1 - Carter Giesbrecht - 3184975
public class CircularDoublyLinkedList<E> {
    private static class Node<E>{
        private E element;  //reference to the element stored at this node
        private Node<E> prev;   // reference to the previous node in the list
        private Node<E> next;   //reference to the next node in the list
        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            next = n;
            prev = p;
        }
        public E getElement(){return element;}
        public Node<E> getPrev(){return prev;}
        public Node<E> getNext(){return next;}
        public void setPrev(Node<E> p){prev = p;}
        public void setNext(Node<E> n){next = n;}
    } // end of nested node
    //instance variables of the DoublyLinkedList
    private Node<E> tail = null;
    private int size;
    private boolean reversed;
    //construct new empty list
    public CircularDoublyLinkedList(){
    }
    //returns size of linked list
    public int size(){return size;}
    //tests if the list is empty
    public boolean isEmpty(){return size == 0;}
    //returns (not remove) the first element of the list
    public E first()
    {
        if(isEmpty()) {return null;}
        return tail.getNext().getElement();
    }
    //returns (not remove) the last element of the list
    public E last()
    {
        if(isEmpty()) {return null;}
        return tail.getElement();
    }
    //public update methods...
    //Adds element e to the front of the list
    public void addFirst(E e)
    {
        //addBetween(e, header, header.getNext());
        if(size == 0)
        {
            Node<E> newest = new Node<>(e, null, null);
            newest.setNext(newest);
            newest.setPrev(newest);
            tail = newest;
        }
        else{
            Node<E> head = tail.getNext();
            Node<E> newest = new Node<>(e,tail, head);
            tail.setNext(newest);
            head.setPrev(newest);
        }
        size++;
    }
    //Adds element e to the end of the list
    public void addLast(E e)
    {
        //addBetween(e, header.getPrev(), header);
        addFirst(e);
        tail = tail.getNext();
    }
    //removes and returns the first element of the list
    public E removeFirst()
    {
        if(isEmpty()) {return null;}

            return remove(tail.getNext());
    }
    //removes and returns the last element of the list
    public E removeLast(){
        if(isEmpty()) {return null;}
        return remove(tail);
    }

    public void rotate()
    {
        //rotate through normally
        if(tail != null && !reversed)
        {
            tail = tail.getNext();
        }
        //rotate through reversed
        else if(reversed)
        {
            tail = tail.getPrev();
        }
    }

    public void reverse()
    {
        //set reverse to true if it is not already, if not, set reverse to false
        if(!reversed) {
            reversed = true;
        }
        else{ reversed = false; }
    }

    public String toString()
    {
        if(isEmpty()) {return "()";}

        StringBuilder sb = new StringBuilder(); //for string output
        sb.append("(");
        Node<E> current = tail.getNext();

        for (int i = 0; i < size; i++) { //loop through all values and add to stringbuilder
            sb.append(current.getElement());
            current = current.getNext();
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append(")"); //close brackets for output
        return sb.toString();
    }
    //private update methods...
    //removes the given node from the list and returns its element
    private E remove(Node<E> node)
    {
        Node<E> predecessor = node.getPrev();
        Node<E> sucessor = node.getNext();
        predecessor.setNext(sucessor);
        sucessor.setPrev(predecessor);

        if(node == tail) // if the removes node is the tail, update tail
        {
            tail = predecessor;
        }
        size--;
        return node.getElement();
    }
} // end of DoublyLinkedList
