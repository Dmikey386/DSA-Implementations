# Data Structures & Algorithms in Java

### Author: Michael Dodd

## About This Repository

Welcome to my **Data Structures & Algorithms (DSA) playground!** 🏗️  
This repo is where I break down, rebuild, and experiment with fundamental **DSA concepts in Java**.

### Purpose

I'm doing this to deepen my understanding of Data Structures and Algorithms, and becasue it will be a fun and interesting project.

## Dynamic Array
### ** Time Complexities (Big-O)**
| Operation           | Method                      | Time Complexity |
|---------------------|---------------------------|---------------|
| **Adding element to end** | `add(T element)`          | **O(1)** (Amortized, O(n) when resizing) |
| **Adding element at index** | `add(int index, T element)` | **O(n)** (Shift elements right) |
| **Get element** | `get(int index)`          | **O(1)** |
| **Check length** | `length()`               | **O(1)** |
| **Check if empty** | `isEmpty()`             | **O(1)** |
| **Find index of element** | `indexOf(T element)` | **O(n)** |
| **Check if contains** | `contains(T element)` | **O(n)** |
| **Remove by element** | `remove(T element)`   | **O(n)** (Shift elements left) |
| **Remove by index** | `removeIndex(int index)` | **O(n)** (Shift elements left) |
| **Resize array** | `resize()`              | **O(n)** (Copy elements to new array) |
| **Print elements** | `print()`               | **O(n)** |
| **Clear array** | `clear()`               | **O(n)** (Set all elements to `null`) |


---

## **Singly Linked List**
### **Time Complexities (Big-O)**

| Operation           | Method                      | Time Complexity |
|---------------------|---------------------------|---------------|
| **Add to end** | `append(T data)`          | **O(1)** |
| **Add to front** | `prepend(T data)`         | **O(1)** |
| **Insert at index** | `insert(int index, T data)` | **O(n)** (Traverse to index) |
| **Get element** | `get(int index)`          | **O(n)** (Traverse to index) |
| **Check length** | `length` (field access)  | **O(1)** |
| **Check if empty** | `head == null`         | **O(1)** |
| **Remove from front** | `removeFront()`        | **O(1)** |
| **Remove from end** | `removeEnd()`          | **O(n)** (Traverse to second-last node) |
| **Remove by index** | `remove(int index)`    | **O(n)** (Traverse to index) |
| **Traverse to index** | `traversal(int index)` | **O(n)** |

---

