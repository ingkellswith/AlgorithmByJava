package ingkells.with.baekjoon.theory.sorting;

import java.util.PriorityQueue;

public class HeapSortWithPriorityQueue {
    public static void heapSort(int[] arr) {
        // 우선순위 큐를 사용하여 최대 힙을 생성
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> a - b);

        // 배열의 모든 원소를 최대 힙에 추가
        for (int num : arr) {
            maxHeap.add(num);
        }

        // 최대 힙에서 원소를 하나씩 추출하여 배열에 저장 (정렬된 순서로)
        for (int i = 0; i < arr.length; i++) {
            arr[i] = maxHeap.poll();
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 9, 1, 5, 6 };
        heapSort(arr);

        System.out.println("정렬된 배열:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}