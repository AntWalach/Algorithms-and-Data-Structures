package pl.AlgAndDataStruct;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

    SearchAlgorithms searchAlgorithms = new SearchAlgorithms();

//
//        ArrayList <Integer> arrayList = new ArrayList<Integer>();
//
//
//        arrayList.add(3);
//        arrayList.add(2);
//        arrayList.add(53);
//        arrayList.add(4);
//        arrayList.add(56);
//        arrayList.add(123);
//        arrayList.add(2);
//        arrayList.add(4);
//        arrayList.add(5);
//        arrayList.add(6);
//        arrayList.add(5);
//
//        System.out.println(searchAlgorithms.linearSearch(arrayList,3));
//
//        Collections.sort(arrayList);
//        System.out.println(arrayList.toString());
//
//        System.out.println(searchAlgorithms.binarySearch(arrayList,123));
//        System.out.println(searchAlgorithms.linearSearch(arrayList,6));

//        ListArray listArray = new ListArray(10);
//        ListArray listArray1 = new ListArray(10);
//
//
//        listArray.append(5);
//        listArray.append(5);
//        listArray1.append(3);
//        listArray1.append(3);
//        listArray1.append(3);
//        listArray.preppend(1);
//
//        listArray.insert(0,10);
//
//      //  listArray.del(1);
//
//       // listArray.deleteX(5);
//
//        listArray.printList();
//        System.out.println("\n");
//
//        listArray.concat(listArray1);
//
//        listArray.printList();
//
//        System.out.println("\n");
//
//        listArray1.printList();
//
//
//        System.out.println(listArray.getTail());
//        System.out.println(listArray.getSize());
//

//ListLinked listLinked = new ListLinked();
//
//
//listLinked.append(1);
//listLinked.append(2);
//listLinked.append(3);
//listLinked.append(4);
//
//listLinked.preppend(10);
//
//listLinked.print();
//
//        System.out.println("\n");
//
//listLinked.del(listLinked.locate(1));
//        listLinked.print();
//
//        listLinked.clear();
//
//
//        System.out.println("test");
//        listLinked.print();



        BSTree bsTree = new BSTree();


        bsTree.insert(15);
        bsTree.insert(2);
        bsTree.insert(1);
        bsTree.insert(5);
        bsTree.insert(3);
        bsTree.insert(7);
        bsTree.insert(14);
        bsTree.insert(9);
        bsTree.insert(17);
        bsTree.insert(18);
        bsTree.insert(45);
        bsTree.insert(19);
        bsTree.insert(50);


        System.out.println(bsTree.size(bsTree.getRoot()));

        System.out.println(" ");

        bsTree.inorder(bsTree.getRoot());

        System.out.println(" ");

        System.out.println(bsTree.search(15).getValue());

        System.out.println(" ");

        Node result = bsTree.search(49);
        if (result != null) {
            int nodeValue = result.getValue();
            // Perform operations with nodeValue
            System.out.println("Found value: " + nodeValue);
        } else {
            System.out.println("Value not found");
        }


        System.out.println();

        bsTree.del(bsTree.search(7));

        System.out.println();

        bsTree.inorder(bsTree.getRoot());



    }
}