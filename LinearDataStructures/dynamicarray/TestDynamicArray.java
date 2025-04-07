package LinearDataStructures.dynamicarray;

public class TestDynamicArray {
    public static void main(String[] args) {
        // Create a Dynamic Array with default size (capacity = 10)
        DynamicArray<Integer> arr = new DynamicArray<>(3);

        arr.add(1);  // O(1)
        arr.add(2);  // O(1)
        arr.add(3);  // O(1)
        arr.add(4); // O(n) array resize
        arr.add(1, 99); // O(n) (shifts elements right)
        System.out.println("Element at index 2: " + arr.get(2)); // O(1) -> 3
        System.out.println("\nArray length: " + arr.length()); // O(1) -> 5
        System.out.println("Is the array empty? " + arr.isEmpty()); // O(1) -> false
        System.out.println("\nIndex of 99: " + arr.indexOf(99)); // O(n) -> 1
        System.out.println("Does the array contain 2? " + arr.contains(2)); // O(n) -> true
        arr.remove(99); // O(n)
        arr.removeIndex(1); //O(n)
        arr.clear(); // O(n)
        arr.print(); // Output: []
        System.out.println("Is the array empty? " + arr.isEmpty()); // O(1) -> true
    }
}
