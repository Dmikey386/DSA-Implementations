package LinearDataStructures.LinkedList;

public class DoublyLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int length = 0;

    public DoublyLinkedList() {
    }

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        // Node class constructor
        public Node (T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public void append(T data) {
        if (length == 0) {
            head = new Node<>(data);
            tail = head;
            length++;
        }
        else {
            Node<T> newNode = new Node<>(data);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            length++;
        }
    }
    public void prepend(T data) {
        if (length == 0) {
            head = new Node<>(data);
            tail = head;
            length++;
        }
        else {
            Node<T> newNode = new Node<>(data);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            length++;
        }
    }
    public T remove(int index) {
        if (index == 0) {
            return popHead();
        }
        else if (index == length-1){
            return popTail();
        }
        else {
            Node<T> traversal = traversal(index);
            Node<T> prev = traversal.prev;
            Node<T> next = traversal.next;
            next.prev = prev;
            prev.next = next;
            length--;
            return traversal.data;
        }

    }

    public T popHead(){
        Node<T> traversal = head;
        if (head == tail){
            head = tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
        }

        length--;
        return traversal.data;
    }
    public T popTail(){
        Node<T> traversal = tail;
        if (head == tail){
            head = tail = null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
        }

        length--;
        return traversal.data;
    }

    public void insert(int index, T data) {
        if (length == 0) {
            head = new Node<>(data);
            tail = head;
            length++;
        }
        else if (index == 0){
            prepend(data);
        }
        else if (index == length){
            append(data);
        }
        else {
            Node<T> newNode = new Node<>(data);
            Node<T> traversal = traversal(index);
            Node<T> prev = traversal.prev;
            traversal.prev = newNode;
            newNode.next = traversal;
            prev.next = newNode;
            newNode.prev = prev;
            length++;
        }

    }
    public Node<T> traversal(int index) {
        int center = length / 2;
        if (index >= center) {
            return revTraversal(index);
        }
        else {
            return fwdTraversal(index);
        }
    }

    public Node<T> fwdTraversal(int index) {
        Node<T> traversal = head;
        for (int i = 0; i < index; i++) {
            traversal = traversal.next;
        }
        return traversal;
    }

    public Node<T> revTraversal(int index) {
        Node<T> traversal = tail;
        int travLength = length - index - 1;
        for (int i = 0; i < travLength; i++) {
            traversal = traversal.prev;

        }
        return traversal;
    }
    // print linked list items for testing
    public void printLinkedList() {
        Node<T> traversal = head;
        System.out.print("[");
        while (traversal != null) {
            System.out.print(traversal.data + " <-> ");
            traversal = traversal.next;
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args){
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
        linkedList.append(1); //0
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5); //4
        linkedList.append(6);// 5
        linkedList.append(7);
        linkedList.append(8);
        linkedList.append(9);
        linkedList.append(10); // 9

        linkedList.insert(5,20);
        linkedList.insert(6,30);
        linkedList.printLinkedList();
        System.out.println(linkedList.remove(0));
        System.out.println(linkedList.remove(linkedList.length-1));
        linkedList.printLinkedList();
    }
}
