package LinearDataStructures.stack;

import java.util.Stack;

public class StackArray<T> {
    T[] stack;
    int length = 0;
    int capacity;

    public StackArray(){
        this.capacity = 10;
        this.stack = (T[]) new Object[capacity];
    }

    public StackArray(int capacity) {
        this.stack = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public boolean isEmpty(){
        return length == 0;
    }
    public int size(){
        return length;
    }
    public T peek(){
        return isEmpty() ? null : stack[length - 1];
    }

    public T pop(){
        if (isEmpty()){
            return null;
        }
        T value = stack[--length];
        stack[length] = null;
        return value;
    }
    public void push(T value){
        if (length == capacity) {
            resize();
        }
        stack[length] = value;
        length++;
    }
    public void resize(){
        T[] temp = stack;
        capacity *= 2;
        T[] newStack = (T[]) new Object[capacity];
        for (int i = 0; i < length; i++) {
            newStack[i] = temp[i];
        }
        stack = newStack;
    }

    public static void main(String[] args) {
        StackArray<Integer> stack = new StackArray<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // Bottom -> 1 -> 2 -> 3 -> Top
        System.out.println(stack.peek()); // 3
        System.out.println(stack.pop());  // 3
        System.out.println(stack.pop());  // 2
        System.out.println(stack.peek()); // 1
        System.out.println(stack.isEmpty()); // false
        System.out.println(stack.size());    // 1
    }

}
