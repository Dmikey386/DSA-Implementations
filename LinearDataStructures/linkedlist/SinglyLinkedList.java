package LinearDataStructures.linkedlist;

public class SinglyLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int length;

    // Linked list constructor
    public SinglyLinkedList(T data) {
        head = new Node<>(data);
        tail = head;
        length = 1;
    }

    // static class Node
    private static class Node<T> {
        T data;
        Node<T> next;

        // Node class constructor
        public Node (T data) {
            this.data = data;
            this.next = null;
        }

    }

    public void append(T data) {
        // append to end of linked list O(1)
        Node<T> newNode = new Node<>(data);
        if (tail == null) {  // Check if the list is empty
            head = newNode;
            tail = newNode;
            length = 1;

        } else {
            tail.next = newNode;
            tail = newNode;
            length++;
        }
    }

    public void prepend(T data) {
        // append to front of linked list O(1)
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            length = 1;
        }
        else {
            newNode.next = head;
            head = newNode;
            length++;
        }
    }

    public void insert(int index, T data) {
        // insert at desired position of linked list O(n)
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
            Node<T> newNode = new Node<>(data);
            Node<T> beforeNode = traversal(index-1);
            Node<T> afterNode = beforeNode.next;
            beforeNode.next = newNode;
            newNode.next = afterNode;
            length++;
        }

    }

    public T removeFront(){
        if (head == null) { return null; }
        // remove from front of linked list O(1)
        T data = head.data;
        head = head.next;
        length--;
        return data;
    }

    public T removeEnd() {
        // remove from end of linked list O(n)
        if (head == null) {
            return null;
        }

        T data = tail.data;

        if (length == 1) {
            head = null;
            tail = null;
        } else {
            Node<T> newTail = traversal(length - 2);
            newTail.next = null;
            tail = newTail;
        }
        length--;
        return data;
    }


    public T remove(int index){
        // remove from desired index O(n)
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0){
            return removeFront();
        }

        Node<T> beforeIndexNode = traversal(index-1);
        Node<T> removeNode = beforeIndexNode.next;
        T data = removeNode.data;
        beforeIndexNode.next = removeNode.next;
        length--;
        return data;
    }

    public Node<T> traversal(int index){
        // traverse through linked list O(n)
        if (index >= length){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> traversal = head;
        for (int i = 0; i < index; i++) {
            traversal = traversal.next;
        }
        return traversal;
    }

    public T get(int index){
        // get data at desired index O(n)
        Node<T> traversal = traversal(index);
        return traversal.data;
    }

    // print linked list items for testing
    public void printLinkedList() {
        Node<T> traversal = head;
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
        myLinkedlist.printLinkedList();
        myLinkedlist.insert(3,21);
        myLinkedlist.printLinkedList();
        myLinkedlist.removeFront();
        myLinkedlist.printLinkedList();
        myLinkedlist.removeEnd();
        myLinkedlist.printLinkedList();
        myLinkedlist.remove(4);
        myLinkedlist.printLinkedList();
        System.out.println(myLinkedlist.get(3));
//    [10 --> 1 --> 2 --> 3 --> ]
//[12 --> 11 --> 10 --> 1 --> 2 --> 3 --> ]
//[12 --> 11 --> 20 --> 10 --> 1 --> 2 --> 3 --> ]
//[12 --> 11 --> 20 --> 21 --> 10 --> 1 --> 2 --> 3 --> ]
//[11 --> 20 --> 21 --> 10 --> 1 --> 2 --> 3 --> ]
//[11 --> 20 --> 21 --> 10 --> 1 --> 2 --> 3 --> ]
//[11 --> 20 --> 21 --> 10 --> 2 --> 3 --> ]
//       10

    }
}
