package ingkells.with.baekjoon.theory.sorting;

import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 9, 1, 5, 6 };

        quickSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // https://namu.wiki/w/%EC%A0%95%EB%A0%AC%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98#s-4.2.3
    // 원리 참고
    static void quickSort(int[] arr, int left, int right) {
        // base condition
        if (left >= right) {
            return;
        }
        int pivot = arr[right];

        int sortedIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, sortedIndex);
                sortedIndex++;
            }
        }
        swap(arr, sortedIndex, right);
        quickSort(arr, left, sortedIndex - 1);
        quickSort(arr, sortedIndex + 1, right);
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}