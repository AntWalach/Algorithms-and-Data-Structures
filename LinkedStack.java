package pl.AlgAndDataStruct;

import pl.AlgAndDataStruct.Element;

public class LinkedStack {

    private Element top;


    LinkedStack() {
        top = null;
    }

    boolean empty() {
        if (top == null)
            return true;
        return false;
    }


    void push(int x) {
        if (top == null) {
            top = new Element(x, null);
        } else {
            Element el = new Element(x, top);
            top = el;
        }
    }


    int peek() {
        if (!empty())
            return top.getV();

        System.out.println("There is no element (stack is empty) ");
        return Integer.MIN_VALUE;
    }


    void pop() {
        if (!empty()) {
            Element tmp = top;
            top = top.getNext();
            tmp = null;
        } else
            System.out.println("There is no element (stack is empty) ");
    }

    void print() {
        if (!empty()) {
            Element tmp = top;
            while (tmp != null) {
                System.out.println(tmp.getV());
                tmp = tmp.getNext();
            }
        }
    }


}
