package pl.AlgAndDataStruct;

public class ArrayFifo {


    private int capacity;
    private int[] items;
    private int size;
    private int head;
    private int tail;

    ArrayFifo(int c) {
        capacity = c;
        items = new int[capacity];
        size = 0;
        head = -1;
        tail = -1;
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

    void enqueue(int x) {
        if (full())
            System.out.println("Queue is full, you can't add any element.");
        else {
            if (head == -1) {
                head++;
                tail++;
                size++;
                items[head] = x;
            }
            //to można element dodać
            else if ((tail + 1) % capacity != head) {
                tail++;
                size++;
                items[tail % capacity] = x;
                tail = tail % capacity;
            }
        }
    }


    int peek() {
        if (empty()) {
            System.out.println("There is no value, queue is empty ");
            return Integer.MIN_VALUE;
        } else
            return items[head];
    }

    void dequeue() {
        if (!empty()) {
            head = (head + 1) % capacity;
            size--;
        } else
            System.out.println("Queue is empty! You can't dequeue any value.");
    }

    void printFifo() {
        if (tail == head)
            System.out.println(items[head]);
        else
            for (int i = 0; i <= tail; i++)
                System.out.println(items[i]);
    }


}
