# Data Structures & Algorithms in Java

### Author: Michael Dodd

## About This Repository

My **Data Structures & Algorithms** Java implementations 
This repo is where I break down, rebuild, and experiment with fundamental **DSA concepts in Java**.

### Purpose

I'm doing this to deepen my understanding of Data Structures and Algorithms, and because it will be a fun and interesting project.

---

## **Dynamic Array**
### **Time Complexities (Big-O)**

| Operation              | Method                        | Time Complexity |
|------------------------|-------------------------------|-----------------|
| Add to end             | `add(T element)`              | O(1) Amortized / O(n) (on resize) |
| Add at index           | `add(int index, T element)`   | O(n) |
| Get element            | `get(int index)`              | O(1) |
| Check length           | `length()`                    | O(1) |
| Check if empty         | `isEmpty()`                   | O(1) |
| Find index             | `indexOf(T element)`          | O(n) |
| Contains element       | `contains(T element)`         | O(n) |
| Remove by element      | `remove(T element)`           | O(n) |
| Remove by index        | `removeIndex(int index)`      | O(n) |
| Resize array           | `resize()`                    | O(n) |
| Print elements         | `print()`                     | O(n) |
| Clear array            | `clear()`                     | O(n) |

---

## **Singly Linked List**
### **Time Complexities (Big-O)**

| Operation              | Method                         | Time Complexity |
|------------------------|--------------------------------|-----------------|
| Add to end             | `append(T data)`               | O(1) |
| Add to front           | `prepend(T data)`              | O(1) |
| Insert at index        | `insert(int index, T data)`    | O(n) |
| Get element            | `get(int index)`               | O(n) |
| Check length           | `length` (field access)        | O(1) |
| Check if empty         | `head == null`                 | O(1) |
| Remove from front      | `removeFront()`                | O(1) |
| Remove from end        | `removeEnd()`                  | O(n) |
| Remove by index        | `remove(int index)`            | O(n) |
| Traverse to index      | `traversal(int index)`         | O(n) |

---

## **Stack (Array & Linked List)**
### **Time Complexities (Big-O)**

| Operation              | Method         | Time Complexity |
|------------------------|----------------|-----------------|
| Push (add to top)      | `push(T data)` | O(1) |
| Pop (remove top)       | `pop()`        | O(1) |
| Peek (view top)        | `peek()`       | O(1) |
| Check size             | `size()`       | O(1) |
| Check if empty         | `isEmpty()`    | O(1) |

*Both array and linked list implementations maintain the same complexity.*

---

## **Singly Circular Linked List**
### **Time Complexities (Big-O)**

| Operation              | Method                         | Time Complexity |
|------------------------|--------------------------------|-----------------|
| Add to end             | `append(T data)`               | O(1) |
| Add to front           | `prepend(T data)`              | O(1) |
| Insert at index        | `insert(int index, T data)`    | O(n) |
| Remove from end        | `pop()`                        | O(n) |
| Remove by index        | `remove(int index)`            | O(n) |
| Traverse to index      | `traverse(int index)`          | O(n) |
| Circular property      | `tail.next == head`            | O(1) |

---

## **Doubly Circular Linked List**
### **Time Complexities (Big-O)**

| Operation              | Method                         | Time Complexity |
|------------------------|--------------------------------|-----------------|
| Add to end             | `append(T data)`               | O(1) |
| Add to front           | `prepend(T data)`              | O(1) |
| Insert at index        | `insert(int index, T data)`    | O(n) |
| Remove from end        | `pop()`                        | O(1) |
| Remove by index        | `remove(int index)`            | O(n) |
| Traverse to index      | `traverse(int index)`          | O(n) |
| Bidirectional access   | `next / prev` pointers         | O(1) |
| Circular property      | `tail.next == head`, `head.prev == tail` | O(1) |

---

