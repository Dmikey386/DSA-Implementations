package LinearDataStructures.linkedlist;

public class SingularCircularLinkedList<T> {
        Node<T> head;
        Node<T> tail;
        int length;

    public SingularCircularLinkedList() {

    }
    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    public boolean isEmpty() {
        return head == null;
    }

    public void append(T data) {
        if (isEmpty()) {
            head = new Node<>(data);
            tail = head;
            head.next = tail;
            tail.next = head;
        } else {
            Node<T> newNode =  new Node<>(data);
            tail.next = newNode;
            tail = newNode;
            newNode.next = head;
        }
        length++;
    }
    public void prepend(T data) {
        if (isEmpty()) {
            head = new Node<>(data);
            tail = head;
            head.next = tail;
            tail.next = head;
        } else {
            Node<T> newNode =  new Node<>(data);
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        }
        length++;

    }
    public void insert(T data, int index) {
        if (isEmpty()) {
            head = new Node<>(data);
            tail = head;
            head.next = tail;
            tail.next = head;
        }else{
            Node<T> traversal = traverse(index-1);
            Node<T> newNode = new Node<>(data);
            newNode.next = traversal.next;
            traversal.next = newNode;
        }
        length++;
    }
    public T remove(int index) {
        T data;
        if (length == 1 || index == length-1) {
            data = pop();
        }else {
            Node<T> traversal = traverse(index - 1);
            data = traversal.next.data;
            traversal.next = traversal.next.next;
            length--;
        }
        return data;
    }
    public T pop(){
        T data;
        if (length == 1) {
            data = tail.data;
            head = null;
            tail = null;
        } else{
            Node<T> traversal = traverse(length - 2);
            data = traversal.next.data;
            traversal.next = head;
            tail = traversal;
        }
        length--;
        return data;
    }
    public Node<T> traverse(int index) {
        Node<T> traversal = head;
        for (int i = 0; i < index; i++) {
            traversal = traversal.next;
        }
        return traversal;
    }
    // print linked list items for testing
    public void printLinkedList() {
        Node<T> traversal = head;
        System.out.print("[(" + traversal.data + " Head) --> ");
        traversal = traversal.next;
        for (int i = 1; i < length; i++) {
            System.out.print(traversal.data + " --> ");
            traversal = traversal.next;
        }
        System.out.print("(" + traversal.data + " Head)]");
        System.out.println();
    }
    public static void main(String[] args) {
        SingularCircularLinkedList list = new SingularCircularLinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.insert(10, 3);
        list.printLinkedList();
        list.remove(5);
        list.printLinkedList();

    }
}
