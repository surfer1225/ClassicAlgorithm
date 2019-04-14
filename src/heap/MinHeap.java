package heap;

public class MinHeap {

    private int[] heap;
    private int size;
    private int maxSize;

    private static final int front = 1;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[this.maxSize+1];
        heap[0] = Integer.MIN_VALUE;
    }

    /**
     *
     * @param position: position of the current node
     * @return the postion of its parent node
     */
    private int parent(int position) {
        return position / 2;
    }

    /**
     *
     * @param position: position of the current node
     * @return the postion of its left child
     */
    private int leftChild(int position) {
        return position * 2;
    }

    /**
     *
     * @param position: position of the current node
     * @return the postion of its right child
     */
    private int rightChild(int position) {
        return (position * 2) + 1;
    }

    private boolean isLeaf(int position) {
        if (position >= (size / 2) && position <= size) return true;
        else return false;
    }

    private void swap(int fpos, int spos) {
        int temp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = temp;
    }

    private void minHeapify(int pos) {
        // if the node is a non-leaf node and greater than any its child
        if (!isLeaf(pos)) {
            if (heap[pos]>heap[leftChild(pos)]) {
                swap(pos, leftChild(pos));
                minHeapify(leftChild(pos));
            }
            else if (heap[pos]>heap[rightChild(pos)]) {
                swap(pos, rightChild(pos));
                minHeapify(rightChild(pos));
            }
        }
    }

    private void insert(int element) {
        heap[++size] = element;
        int cur = size;

        while (heap[cur] < heap[parent(cur)]) {
            swap(cur, parent(cur));
            cur = parent(cur);
        }
    }

    public void minHeap() {
        for (int pos=(size/2);pos>=1;pos--) minHeapify(pos);
    }

    public int remove() {
        int popped = heap[front];
        heap[front] = heap[size--];
        minHeapify(1);
        return popped;
    }

    // Function to print the contents of the heap
    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + heap[i]
                    + " LEFT CHILD : " + heap[2 * i]
                    + " RIGHT CHILD :" + heap[2 * i + 1]);
            System.out.println();
        }
    }

    // Driver code
    public static void main(String[] arg)
    {
        System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.minHeap();

        minHeap.print();
        System.out.println("The Min val is " + minHeap.remove());
    }
}
