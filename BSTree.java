package pl.AlgAndDataStruct;

public class BSTree {


    private Node root;


    BSTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }


    boolean empty(Node p) {
        if (p == null)
            return true;
        return false;
    }

    void inorder(Node p) {
        if (!empty(p)) {
            inorder(p.getLeft());
            System.out.print(p.getValue() + " ");
            inorder(p.getRight());
        }
    }


    int size(Node p) {
        if (empty(p))
            return 0;
        else
            return (1 + size(p.getLeft()) + size(p.getRight()));
    }


    int hight(Node p) {
        if (empty(p))
            return -1;
        else
            return (1 + Integer.max(hight(p.getLeft()), hight(p.getRight())));
    }


    void clear(Node p) {
        if (p == root)
            root = null;
        clear(p.getLeft());
        clear(p.getRight());
        p = null;
    }


    void insert(int x) {

        Node n = new Node(x, null, null, null);
        if (root == null) {
            root = n;
        } else {
            boolean stop = false;
            Node tmp = root;
            while (!stop) {
                if (tmp.getValue() > x) {
                    if (!empty(tmp.getLeft())) {
                        tmp = tmp.getLeft();
                    } else {
                        tmp.setLeft(n);
                        n.setParent(tmp);
                        stop = true;
                    }
                }
                if (tmp.getValue() < x) {
                    if (!empty(tmp.getRight())) {
                        tmp = tmp.getRight();
                    } else {
                        tmp.setRight(n);
                        n.setParent(tmp);
                        stop = true;
                    }
                }
            }
        }
    }

//    Node search(int x) {
//
//
//
//        Node n = root;
//
//
//        while (!empty(n) && n.getValue() != x) {
//
//            if (n.getRight().getValue() >= x)
//                n = n.getLeft();
//            else if (n == null) {
//                System.out.println(" Brak elementu ");
//
//            } else
//                n = n.getRight();
//        }
//        return n;
//    }


    public Node search(int value) {
        Node current = root;
        while (current != null) {
            int currentValue = current.getValue();
            if (value == currentValue) {
                return current;
            } else if (value < currentValue) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null; // Value not found
    }

    Node minimum(Node p) {
        if (empty(p))
            return null;
        Node n = p;

        while (!empty(n.getLeft())) {
            n = n.getLeft();
        }
        return n;

    }


    Node maximum(Node p) {
        if (empty(p))
            return null;
        Node n = p;

        while (!empty(n.getRight())) {
            n = n.getRight();
        }
        return n;

    }


    Node successor(Node p) {

        if (empty(p))
            return null;

        else if (!empty(p.getRight()))
            return minimum(p.getRight());

        else {
            Node parent = p.getParent();
            Node tmp = p;
            while (!empty(parent) && parent.getRight() == tmp) {
                tmp = parent;
                parent = tmp.getParent();
            }
            return parent;
        }


    }


    Node predecessor(Node p) {
        if (empty(p))
            return null;

        else if (!empty(p.getLeft()))
            return minimum(p.getLeft());

        else {
            Node parent = p.getParent();
            Node tmp = p;
            while (!empty(parent) && parent.getLeft() == tmp) {
                tmp = parent;
                parent = tmp.getParent();
            }
            return parent;
        }
    }


    boolean leaf(Node p) {
        if (empty(p.getLeft()) && empty(p.getRight()))
            return true;
        return false;
    }

    void del(Node p) {
        if (empty(p))
            System.out.println("Tree is empty.");

        else if (leaf(p)) {
            Node n = p.getParent();
            if (empty(p)) {
                root = null;
                return;
            } else {
                if (n.getLeft() == p)
                    n.setLeft(null);
                else
                    n.setRight(null);
            }

            p = null;

        } else if (!empty(p.getLeft()) && !empty(p.getRight())) {
            Node s = successor(p);
            p.setValue(s.getValue());
            del(s);
        } else {
            Node r;
            if (empty(p.getLeft()))
                r = p.getRight();
            else
                r = p.getLeft();

            Node n = p.getParent();
            if (empty(n)) {
                root = r;
                r.setParent(null);
                return;
            } else {
                if (n.getLeft() == p)
                    n.setLeft(r);
                else
                    n.setRight(r);

                r.setParent(n);
            }
            p = null;
        }

    }

}



