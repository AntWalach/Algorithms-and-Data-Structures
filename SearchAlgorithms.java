package pl.AlgAndDataStruct;

import java.util.ArrayList;

public class SearchAlgorithms {


    int linearSearch(ArrayList<Integer> arrayList, int x) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == x) {
                return i;
            }
        }
        return -1;
    }


    int binarySearch(ArrayList<Integer> arrayList, int x) {

        int l = 0;
        int h = arrayList.size() - 1;

        while (l <= h) {
            int mid = (l + h) / 2;

            if (arrayList.get(mid) == x)
                return mid;
            else if (arrayList.get(mid) > x)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return -1;

    }


    int interpolationSearch(ArrayList<Integer> arrayList, int x) {

        int l = 0;
        int h = arrayList.size() - 1;

        while (l <= h) {

            int mid = l + ((x - arrayList.get(l)) * (h - l) / (arrayList.get(h) - arrayList.get(l)));
            if (arrayList.get(mid) == x)
                return mid;
            else if (arrayList.get(mid) > x)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return -1;

    }


}
