package pl.AlgAndDataStruct;

import static java.lang.Math.random;

public class SortingAlgorithms {

    void print(int[] S, int n) {               //wyświetla dane

        for (int i = 0; i < n; i++) {

            System.out.println(S[i] + " ");

        }
    }

    void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
    void init(int[] S, int n) {               //generuje losowe dane

        for (int i = 0; i < n; i++) {

            S[i] = (int) (random() % 100);

        }
    }
    void insertionSort(int[] S, int n) {
        for (int i = 0; i < n; i++) {
            int aux = S[i];
            for (int j = i - 1; j >= 0; j--) {
                if (S[j] > aux)
                    S[j + 1] = S[j];
                else
                    break;
                S[j] = aux;
            }
        }
    }
    void selectionSort(int[] S, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (S[j] < S[min])
                    min = j;
            }
            swap(S[min], S[i]);
        }
    }
    void bubbleSort(int[] S, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > 0; j--) {
                if (S[j] < S[j - 1])
                    swap(S[j], S[j - 1]);
            }
        }
    }
    //Zadanie 3
    void quickSort(int[] array, int lewy, int prawy)
    {
        if (prawy <= lewy) return;

        int i = lewy - 1, j = prawy + 1,
                pivot = array[(lewy + prawy) / 2]; //wybieramy punkt odniesienia

        while (true)
        {
            //szukam elementu wiekszego lub rownego piwot stojacego
            //po prawej stronie wartosci pivot
            while (pivot > array[++i]);

            //szukam elementu mniejszego lub rownego pivot stojacego
            //po lewej stronie wartosci pivot
            while (pivot < array[--j]);

            //jesli liczniki sie nie minely to zamień elementy ze soba
            //stojace po niewlasciwej stronie elementu pivot
            if (i <= j)
                swap(array[i], array[j]);
            else
                break;
        }

        if (j > lewy)
            quickSort(array, lewy, j);
        if (i < prawy)
            quickSort(array, i, prawy);
    }
    void countSort(int array[], int size)
    {
        // The size of count must be at least the (max+1) but
        // we cannot assign declare it as int count(max+1) in C++ as
        // it does not support dynamic memory allocation.
        // So, its size is provided statically.
        int i1 = 100000;
        int[] output = new int[i1];
        int[] count = new int[i1];
        int max = array[0];

        // Find the largest element of the array
        for (int i = 1; i < size; i++)
        {
            if (array[i] > max)
                max = array[i];
        }

        // Store the count of each element
        for (int i = 0; i < size; i++)
        {
            count[array[i]]++;
        }

        // Store the cummulative count of each array
        for (int i = 1; i <= max; i++)
        {
            count[i] += count[i - 1];
        }

        // Find the index of each element of the original array in count array, and
        // place the elements in output array
        for (int i = size - 1; i >= 0; i--)
        {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copy the sorted elements into original array
        for (int i = 0; i < size; i++)
        {
            array[i] = output[i];
        }
    }








}
