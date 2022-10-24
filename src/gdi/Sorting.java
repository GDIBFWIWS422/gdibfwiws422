package gdi;

import java.util.*;
import java.util.ArrayList;

public class Sorting {

    void insertionsort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[i]) {
                    int wert = array[i];
                    for (int k = i; k > j; k--) {
                        array[k] = array[k-1];
                        
                    }
                    array[j] = wert;
                }
            }
        }
    }
    
    void quicksort(int[] array) {
        quicksort2(array, 0, array.length-1);
    }
    
    void quicksort2(int[]array, int from, int to) {
        if (to - from <= 0) {
            return;
        }
        int pivot = array[to];
        int left = from - 1;
        int right = to;
        while(left<right) {
            left++;
            for(;array[left]<pivot;left++);
            right--;
            for(;right>from && array[right]>=pivot;right--);
            int value = array[left];
            array[left] = array[right];
            array[right] = value; 
        }
        int value = array[left];
        array[left] = array[right];
        array[right] = value; 
        array[to] = array[left];
        array[left] = pivot;
        quicksort2(array, from, left-1);
        quicksort2(array, left+1, to);
    }
    
    void mergesort(int[] array) {
         mergesort2(array, 0, array.length -1);
        
    }
    void mergesort2(int[] array, int from, int to) {
        if(to - from <=1) {
            return;
        }
        int middle= (from + to)/2;
        mergesort2(array, from, middle);
        mergesort2(array, middle +1, to);
    }

    public static void main(String[] args) {
        java.util.List<int[]> data = new ArrayList<int[]>();
        data.add(new int[] {1,2,3,4,5,6,7,8});
        data.add(new int[] {8,7,6,5,4,3,2,1});
        data.add(new int[] {4,3,6,5,8,9,2,1});
        int index = 0;
        for (int[] array : data) {
            new Sorting().quicksort(array);
            if (!sorted(array)) {
                System.out.println("Quicksort hat einen Fehler für Beispiel " + index + "!");
            }
            index++;
        }
        Random gen = new Random();
        for (int i = 0; i < 100; i++) {
            int[] array = new int[gen.nextInt(20) + 5];
            for (int j = 0; j < array.length; j++) {
                array[j] = gen.nextInt();
            }
            new Sorting().quicksort(array);
            if (!sorted(array)) {
                System.out.println("Quicksort hat einen Fehler!");
            }
        }
        System.out.println("Test fertig!");
    }

    static boolean sorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
