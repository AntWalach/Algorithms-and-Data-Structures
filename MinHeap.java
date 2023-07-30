package pl.AlgAndDataStruct;


public class MinHeap {

    private int[] heap;
    private int capacity;
    private int size;

    MinHeap(int c) {
        heap = new int[c];
        capacity = c;
        size = 0;
    }

    MinHeap() {
        capacity = 11;
        size = 11;
        heap = new int[]{1, 2, 4, 6, 5, 4, 7, 7, 7, 9, 6};
    }

    boolean empty() {
        if (size == 0)
            return true;
        return false;
    }

    boolean full() {
        if (size == capacity)
            return true;
        return false;
    }

    int getLeft(int i) {
        if (2 * i + 1 < size)
            return 2 * i + 1;
        return -1;
    }

    int getRight(int i) {
        if (2 * i + 2 < size)
            return 2 * i + 2;
        return -1;
    }


    int getParent(int i) {
        if (i == 0)
            return -1;
        return (i - 1) / 2;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    int getValue(int i) {
        return heap[i];
    }

    void setValue(int i, int x) {
        if (full())
            System.out.println("Heap is full");
        else {
            heap[i] = x;
            bottomUp(i);
            size++;
        }
    }

    void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    void bottomUp(int i) {
        if (i > 0) {
            int p = getParent(i);
            if (heap[p] > heap[i]) {
                swap(heap[p], heap[i]);
                bottomUp(p);
            }
        }
    }


    void topDown(int i) {
        int l = getLeft(i);
        int r = getRight(i);
        int g = i;
        if (l != -1 && heap[l] < heap[i]) {
            g = l;
        }
        if (r != -1 && heap[r] < heap[g]) {
            g = r;
        }
        if (g != i) {
            swap(heap[i], heap[g]);
            topDown(g);
        }
    }


    void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");

        }
    }

    void insert(int x) {
        if (full()) {
            System.out.println("Heap is full.");
        } else {
            heap[size] = x;
            bottomUp(size);
            size++;
        }
    }


    void deleteMin() {
        if (empty()) {
            System.out.println("Heap is empty.");
        } else {
            size--;
            swap(heap[0], heap[size]);

            //bottomUp(0);
            topDown(0);
        }
    }

    int minimum() {
        if (!empty())
            return heap[0];
        else
            System.out.println("Heap is empty.");
        return -1;
    }

    void del(int i) {
        if (empty())
            System.out.println("Heap is empty.");
        else {
            size--;
            swap(heap[i], heap[size]);
            topDown(i);
            bottomUp(i);
        }
    }

    void decreaseKey(int i, int x) {
        heap[i] = x;
        bottomUp(i);
    }

}
