package pl.AlgAndDataStruct;

public class LinkedFifo {

    private Element head;
    private Element tail;

    LinkedFifo() {
        head = null;
        tail = null;
    }

    boolean empty() {
        if (head == null)
            return true;
        return false;
    }

    void enqueue(int x) {
        if (head == null) {
            head = new Element(x, null);
            tail = head;
        } else {
            Element el = new Element(x, null);
            tail.setNext(el);
            tail = el;
        }
    }

    int peek() {
        return head.getV();
    }


    void dequeue() {
        if (empty())
            System.out.println("You can't dequeue any element, there is no element in this queue.");
        else {
            Element tmp = head;
            head = head.getNext();
            tmp = null;
        }
    }


    void print(){
        Element tmp = head;
        while (tmp != null){
            System.out.println(tmp.getV());
            tmp = tmp.getNext();
        }

    }









}
