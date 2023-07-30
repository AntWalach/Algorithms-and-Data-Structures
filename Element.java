package pl.AlgAndDataStruct;

public class Element {


    private int v;

    private Element next;

    private Element prev;

    Element(){
        v = -1;
        prev = null;
        next = null;
    }


    Element(int x, Element next, Element prev){
        this.v = x;
        this.prev = prev;
        this.next = next;
    }


    Element(int x, Element next){
        v = x;
        this.next = next;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public Element getPrev() {
        return prev;
    }

    public void setPrev(Element prev) {
        this.prev = prev;
    }

}
