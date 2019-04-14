### Binary Heap

- a complete tree (all levels filled except the last one), nodes in the last row as left as possible
- either min-heap or max-heap, key at root must be min/max among all keys in the heap, the same property remains recursively true going down

#### Representation
- normally represented as array
- root at Arr[0]
- Arr[(i-1)/2]	Returns the parent node
  Arr[(2*i)+1]	Returns the left child node
  Arr[(2*i)+2]	Returns the right child node
- level order traversal going through the array element

#### Applications
- Heap Sort: sort an array in O(n Log n) time
- Priority Queue: Priority queues can be efficiently implemented using Binary Heap because it supports insert(), delete() and extractmax(), decreaseKey() operations in O(logn) time. Binomoial Heap and Fibonacci Heap are variations of Binary Heap. These variations perform union also efficiently
- Graph Algorithms: DJS & Prim's minimum spanning tree

#### Operations on Min Heap
1) getMini(): It returns the root element of Min Heap. Time Complexity of this operation is O(1).

2) extractMin(): Removes the minimum element from MinHeap. Time Complexity of this Operation is O(Logn) as this operation needs to maintain the heap property (by calling heapify()) after removing root.

3) decreaseKey(): Decreases value of key. The time complexity of this operation is O(Logn). If the decreases key value of a node is greater than the parent of the node, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.

4) insert(): Inserting a new key takes O(Logn) time. We add a new key at the end of the tree. IF new key is greater than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.

5) delete(): Deleting a key also takes O(Logn) time. We replace the key to be deleted with minum infinite by calling decreaseKey(). After decreaseKey(), the minus infinite value must reach root, so we call extractMin() to remove the key.


