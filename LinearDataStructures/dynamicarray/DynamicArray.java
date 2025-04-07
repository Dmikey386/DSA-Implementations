package LinearDataStructures.dynamicarray;

public class DynamicArray<T>{
    private T[] array; // Static Array holds data
    private int length = 0; // Length of Array as number of elements
    private int capacity; //Array Capacity


    // Core Construct to specified capacity
    @SuppressWarnings("unchecked")
    public DynamicArray(int capacity){
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        array = (T[]) new Object[capacity];

    }
    // Wrapper Constructor for default size
    public DynamicArray(){
        this(10);
    }
    //Resize array
    @SuppressWarnings("unchecked")
    public void resize(){
        T[] temp = array;
        capacity *= 2;
        array = (T[]) new Object[capacity];

        for (int i = 0; i < length; i++) {
            array[i] = temp[i];
        }
    }

    //Wrapper Add element to end O(1) - shift 0 elements
    public void add(T element){
        this.add(length,element);
    }
    // Core Add element at index O(n)
    public void add(int index, T element){

        if (length == capacity) {
            resize();
        }
        // Shift all elements after index right O(n)
        for (int i = length-1; i >= index; i--) {
            array[i+1] = array[i];
        }
        // reassign index to new element O(1)
        array[index] = element;
        length++;
    }

    // Get length O(1)
    public int length() {
        return length;
    }
    // Get element at index O(1)
    public T get(int index) {
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }
    // Check if array is empty O(1)
    public boolean isEmpty() {
        return length == 0;
    }

    // Check for first index of element O(n)
    public int indexOf(T element){
        for (int i = 0; i <= length-1; i++) {
            if (array[i] == element || (array[i] != null && array[i].equals(element))) {
                return i;
            }
        }
        return -1;
    }

    // Contains method O(n)
    public boolean contains(T element){
        return indexOf(element) != -1; //indexOf() -> O(n)
    }

    // Wrapper Remove - remove first instance of element O(n)
    public boolean remove(T element){
        int index = indexOf(element); // O(n)
        if (index == -1) {
            return false;
        }
        else {
            this.removeIndex(index);
            return true;
        }
    }

    // Core remove method O(n)
    public T removeIndex(int index){
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        T element = array[index];

        // shift items left
        for (int i = index; i < length-1; i++) {
            array[i] = array[i+1];
        }
        array[length-1] = null;
        length--;

        return element;
    }

    // Clear method to remove all items from array O(n)
    public void clear() {
        for (int i = 0; i < length; i++) {
            array[i] = null; // Help garbage collection
        }
        length = 0;
    }

    //Print Array Purely for testing
    public void print(){
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print("]");
    }


}