package com.moleo;

public class Algorithms {
    private static void swap(int[] arr, int a, int b) {
        var temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //Quick sort algorithm
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;

        int i = partition(arr, start, end);

        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j <= end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return i;
    }

    //Bubble sort algorithm
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i <= arr.length; i++) {
            boolean isSorted = false;
            for (int j = 1; j < arr.length - i; j++)
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    isSorted = false;
                }
                if (isSorted)
                    return;
            }
        }

    //Merge sort algorithm
    public static void mergeSort(int[] arr) {
        if (arr.length < 2)
            return;

        int mid = arr.length / 2;

        int[] left = new int[mid];
        for (int i = 0; i < mid; i++)
            left[i] = arr[i];

        int[] right = new int[arr.length - mid];
        for (int i = mid; i < arr.length; i++)
            right[i - mid] = arr[i];

        mergeSort(left);
        mergeSort(right);

        merge(left, right, arr);
    }

    private static void merge(int[] left, int[] right, int[] end) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                end[k++] = left[i++];
            else
                end[k++] = right[j++];
        }

        while (i < left.length)
            end[k++] = left[i++];

        while (j < right.length)
            end[k++] = right[j++];
    }

    //Selection sort algorithm
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }

            swap(arr, i, min);
        }
    }
}
