package pl.AlgAndDataStruct;

import java.util.LinkedList;

public class ListLinked {

    private Element head;
    private Element tail;
    int size;

    ListLinked() {
        head = null;
        tail = null;
        size = 0;
    }

    public Element getHead() {
        return head;
    }

    public Element getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    Element getNext(Element p) {
        return p.getNext();
    }

    Element getPrev(Element p) {
        return p.getPrev();
    }

    int retrieve(Element p) {
        return p.getV();
    }

    Element locate(int x) {
        Element tmp = head;
        while (tmp != null) {
            if (tmp.getV() == x)
                return tmp;
            else
                tmp = tmp.getNext();
        }
        return null;
    }

    void append(int x) {
        if (head == null) {
            Element newElement = new Element(x, null, null);
            head = newElement;
            tail = head;
            size++;
        } else {
            Element tmp = head;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }

            //prev element is tmp, next element is null
            Element newElement = new Element(x, null, tmp);
            tmp.setNext(newElement);
            tail = newElement;
            size++;
        }
    }

    void preppend(int x) {
        //new element will be our new head
        Element newElement = new Element(x, head, null);
        head.setPrev(newElement);
        head = newElement;
        size++;
    }

    void insert(Element p, int x) {
        Element newElement = new Element(x, p, p.getPrev());
        p.setPrev(newElement);
        size++;
    }

    void del(Element p) {
        p.getPrev().setNext(p.getNext());
        p.getNext().setPrev(p.getPrev());

        //p = null;
        size--;
    }

    void clear() {
        Element tmp = head;

        while (head != null) {
            tmp = head;
            head = head.getNext();
            tmp = null;
        }

        head = null;
        tail = null;
        size = 0;

    }


    void print() {
        Element tmp = head;
        while (tmp != null) {
            System.out.println(tmp.getV());
            tmp = tmp.getNext();
        }
    }

}
