package LinearDataStructures.linkedlist;

public class DoublyCircularLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int length = 0;

    public DoublyCircularLinkedList() {
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
    public boolean isEmpty() {
        return head == null;
    }
    public void prepend(T data) {
        if (isEmpty()) {
            head = new Node<>(data);
            tail = head;
            head.next = tail;
            tail.prev = head;
            head.prev = tail;
            tail.next = head;
        } else {
            Node<T> newNode = new Node<>(data);
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
        length++;
    }
    public void append(T data) {
        if (isEmpty()) {
            head = new Node<>(data);
            tail = head;
            head.next = tail;
            tail.prev = head;
            head.prev = tail;
            tail.next = head;
        }else{
            Node<T> newNode = new Node<>(data);
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }
    public T pop(){
        T data;
        if (length == 1) {
            data = head.data;
            head = null;
            tail = null;
        } else {
            data = tail.data;
            head.prev = tail.prev;
            tail.prev.next = head;
            tail = tail.prev;
        }
        length--;
        return data;
    }
    public void insert(int index, T data) {
        if (isEmpty() || index == length) {
            append(data);
        }
        else{
            Node<T> newNode = new Node<>(data);
            Node<T> traversal = traverse(index);
            newNode.next = traversal;
            newNode.prev = traversal.prev;
            traversal.prev.next = newNode;
            traversal.prev = newNode;
            length++;
        }
    }

    public T remove(int index) {
        T data;
        if (length == 1) {
           data = pop();
        } else {
            Node<T> traversal = traverse(index);
            data = traversal.data;
            traversal.prev.next = traversal.next;
            traversal.next.prev = traversal.prev;
            length--;
        }
        return data;
    }
    public Node<T> traverse(int index) {
        Node<T> traversal = head;
        for (int i = 0; i < index; i++) {
            System.out.print(traversal.data + " ");
            traversal = traversal.next;
        }
        return traversal;
    }
    // print linked list items for testing
    public void printLinkedList() {
        Node<T> traversal = head;
        System.out.print("[(" + traversal.data + " Head) <-> ");
        traversal = traversal.next;
        for (int i = 1; i < length; i++) {
            System.out.print(traversal.data + " <-> ");
            traversal = traversal.next;
        }
        System.out.print("(" + traversal.data + " Head)]");
        System.out.println();
    }
    public static void main(String[] args) {
        DoublyCircularLinkedList list = new DoublyCircularLinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.printLinkedList();
        list.pop();
        list.printLinkedList();
    }
}
