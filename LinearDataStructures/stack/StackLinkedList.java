package LinearDataStructures.stack;

public class StackLinkedList<T> {
    Node<T> head;
    int length = 0;

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
    public boolean isEmpty() {
        return length == 0;
    }
    public T peek() {
        return isEmpty() ? null: head.data;
    }
    public int size() {
        return length;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        length++;
    }

    public T pop() {
        if (length == 0) {
            return null;
        }
        T data = head.data;
        head = head.next;
        length--;
        return data;
    }

    public static void main(String[] args) {
        StackLinkedList<Integer> stack = new StackLinkedList<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        // Top -> 30 -> 20 -> 10 -> null
        System.out.println(stack.pop());  // 30
        System.out.println(stack.peek()); // 20
        System.out.println(stack.size()); // 2
        System.out.println(stack.isEmpty()); // false
    }


}
