package pl.AlgAndDataStruct;



public class ListArray {

    private int[] items;
    private int head;
    private int tail;
    private int capacity;
    private int size;


    ListArray(int c) {
        items = new int[c];
        head = -1;
        tail = -1;
        capacity = c;
        size = 0;

    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
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


    int getNext(int p) {

        if (p + 1 <= tail && p + 1 > head) {
            return p - 1;
        } else {
            System.out.println("Wrong index.");
            return -1;
        }
    }

    int getPrev(int p) {

        if (p - 1 <= tail && p - 1 > head) {
            return p - 1;
        } else {
            System.out.println("Wrong index.");
            return -1;
        }
    }

    int retrieve(int p) {

        if (p >= head && p <= tail)
            return items[p];
        return -1;
    }

    void append(int x) {
        if (head == -1) {
            tail++;
            head++;
            size++;
            items[head] = x;
        } else if (tail + 1 < capacity) {
            tail++;
            size++;
            items[tail] = x;

        } else
            System.out.println("Wrong index");
    }


    void preppend(int x) {

        if (head == -1) {
            tail++;
            head++;
            size++;
            items[head] = x;
        } else if (tail + 1 <= capacity) {
            tail++;
            size++;
            for (int i = tail; i > 0; i--)
                items[i] = items[i - 1];
            items[head] = x;
        } else
            System.out.println("Wrong index.");
    }

    void printList() {
        if (tail == head)
            System.out.println(items[head]);
        else
            for (int i = 0; i <= tail; i++)
                System.out.println(items[i]);
    }


    void insert(int p, int x) {
        if (tail + 1 >= capacity)
            System.out.println("Wrong index");
        if (p >= head && p <= tail) {

            for (int i = tail; i >= p; i--)
                items[i + 1] = items[i];
            items[p] = x;
            tail++;
            size++;
        } else
            System.out.println("Wrong index");
    }

    void del(int p) {

        if (p >= head && p < tail) {

            for (int i = p; i < tail; i++)
                items[i] = items[i + 1];

            tail--;
            size--;
        }
    }

    void clear() {
        for (int i = 0; i <= tail; i++)
            items[i] = 0;
    }

    int locate(int x) {
        for (int i = 0; i <= tail; i++)
            if (items[i] == x)
                return i;
        return -1;
    }

    void deleteX(int x) {
        int j = 0;
        for (int i = 0; i <= tail; i++) {
            if (items[i] == x) {
                tail -= 1;
                size -= 1;
                i++;
            }
            items[j] = items[i];
            j++;
        }
    }


    void concat(ListArray l) {
        int j = 0;
        int sum = tail + l.tail+1;
        if (sum< capacity) {
            for (int i = tail+1; i <= sum; i++) {
                items[i] = l.items[j];
                j++;
                //tail++;
            }
            tail = tail + l.tail + 1;
            size = size +l.size;
        }
        else {
            System.out.println("Wrong");
        }
    }


}
