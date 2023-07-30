package pl.AlgAndDataStruct;

public class ArrayStack {


    private int capacity;
    private int[] items;
    private int top;

    ArrayStack(int c) {
        capacity = c;
        items = new int[capacity];
        top = -1;
    }

    boolean empty() {
        if (top == -1)
            return true;
        return false;
    }


    boolean full() {
        if (top == capacity - 1)
            return true;
        return false;
    }

    void push(int x) {
        if (full())
            System.out.println("Stack is full you can't push any value");
        else {
            top += 1;
            items[top] = x;
        }
    }

    int peek() {
        if (!empty())
            return items[top];
        System.out.println("Stack is empty, there is no value (we return MIN_VALUE value)");
        return Integer.MIN_VALUE;
    }


    void pop() {
        if (top == -1)
            System.out.println("Stack is empty, we can't pop the value");
        else {
            items[top] = Integer.MIN_VALUE;
            top--;
        }
    }

    void print() {
        for (int i = top; i >= 0; i--)
            System.out.println(items[i]);
    }

}
