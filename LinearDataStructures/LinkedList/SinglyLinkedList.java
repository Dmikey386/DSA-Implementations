package LinearDataStructures.LinkedList;

import java.util.LinkedList;

public class SinglyLinkedList<T> {
    Node head;
    Node tail;
    int length;

    // Linked list constructor
    public SinglyLinkedList(T data) {
        head = new Node(data);
        tail = head;
        length = 1;
    }

    // static class node
    static class Node<T> {
        T data;
        Node next;

        // node class constructor
        public Node(T data) {
            this.data = data;
            next = null;
        }

    }

    public void append(T data) {
        // append to end of linked list
        Node newNode = new Node(data);
        if (tail == null) {  // Check if the list is empty
            head = newNode;
            tail = newNode;

        } else {
            tail.next = newNode;
            tail = newNode;
            length++;
        }
    }

    public void prepend(T data) {
        // append to front of linked list
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
            length++;
        }
    }

    public void insert(int index, T data) {
        // insert at desired position of linked list
        if (index > length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0){
            prepend(data);
        }
        else if (index == length){
            append(data);
        }
        else {
            Node newNode = new Node(data);
            Node beforeNode = traversal(index-1);
            Node afterNode = beforeNode.next;
            beforeNode.next = newNode;
            newNode.next = afterNode;
            length++;
        }

    }

    public T removeFront(){
        // remove from front of linked list
        T data = (T) head.data;
        head = head.next;
        length--;
        return data;
    }

    public T removeEnd(){
        // remove from the end of the linked list
        T data = (T) tail.data;
        if (length == 1){
            head = null;
            tail = head;
        }
        else{

            tail = traversal(length-1-1);
            tail.next = null;
        }
        length--;
        return data;
    }

    public T remove(int index){
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0){
            return removeFront();
        }
        // remove from desired index of linked list
        Node beforeIndexNode = traversal(index-1);
        Node removeNode = beforeIndexNode.next;
        T data = (T) removeNode.data;
        Node afterIndexNode = removeNode.next;
        beforeIndexNode.next = afterIndexNode;
        length--;
        return data;
    }

    public Node traversal(int index){
        // traverse through linked list
        if (index > length - 1){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node traversal = head;
        for (int i = 0; i < index; i++) {
            traversal = traversal.next;
        }
        return traversal;
    }

    public void printLinkedList() {
        Node traversal = head;
        System.out.print("[");
        while (traversal != null) {
            System.out.print(traversal.data + " --> ");
            traversal = traversal.next;
        }
        System.out.print("]");
        System.out.println();
    }


    public static void main(String[] args) {
        SinglyLinkedList<Integer> myLinkedlist = new SinglyLinkedList<>(10);
        myLinkedlist.append(1);
        myLinkedlist.append(2);
        myLinkedlist.append(3);
        myLinkedlist.printLinkedList();
        myLinkedlist.prepend(11);
        myLinkedlist.prepend(12);
        myLinkedlist.printLinkedList();
        myLinkedlist.insert(2,20);
        myLinkedlist.insert(3,21);
        myLinkedlist.printLinkedList();
        myLinkedlist.removeFront();
        myLinkedlist.printLinkedList();
        myLinkedlist.removeEnd();
        myLinkedlist.printLinkedList();
        myLinkedlist.removeFront();

//[10 --> 1 --> 2 --> 3 --> ]
//[12 --> 11 --> 10 --> 1 --> 2 --> 3 --> ]
//[12 --> 11 --> 20 --> 21 --> 10 --> 1 --> 2 --> 3 --> ]
//[11 --> 20 --> 21 --> 10 --> 1 --> 2 --> 3 --> ]
//[11 --> 20 --> 21 --> 10 --> 1 --> 2 --> ]

    }
}
