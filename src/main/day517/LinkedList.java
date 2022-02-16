package main.day517;

class Node {
    private int value;
    private Node next;
    Node(int number) {
        this.value = number;
        this.next = null;
    }

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }


    public Node getNext(){
        return this.next;
    }

    public void setNext(Node newNext) {
        this.next = newNext;
    }

    public int getValue() {
        return this.value;
    }

}


public class LinkedList {
    private Node head;

    public LinkedList(){
       this.head = null;
    }
    public LinkedList(int [] intVals) {
        this();
        Node last = null;
        for (int item: intVals) {
            if (this.head == null) {
                last = new Node(item);
                this.head = last;
            } else {
                Node newNode =  new Node(item);
                last.setNext(newNode);
                last = newNode;
            }
        }
    }

    public Node getHead(){
        return this.head;
    }
}
