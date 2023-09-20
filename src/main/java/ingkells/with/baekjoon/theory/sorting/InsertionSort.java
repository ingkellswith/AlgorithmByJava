package ingkells.with.baekjoon.theory.sorting;

import java.util.Scanner;

// 자료 배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교하여,
// 자신의 위치를 찾아 삽입함으로써 정렬을 완성한다.
public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        insertionSort(arr);

        for (int num : arr) {
            System.out.println(num);
        }
    }
// 31	25	12	22	11			처음 상태.
// 31	[25]12	22	11		 	두 번째 원소를 부분 리스트에서 적절한 위치에 삽입한다.
// <25>	31	[12]22	11		 	세 번째 원소를 부분 리스트에서 적절한 위치에 삽입한다.
// <12>	25	31	[22]11		 	네 번째 원소를 부분 리스트에서 적절한 위치에 삽입한다.
// 12	<22>25	31	[11]		마지막 원소를 부분 리스트에서 적절한 위치에 삽입한다.
// <11>	12	22	25	31		 	종료.
    static void insertionSort(int[] arr) {
        int n = arr.length;  // 배열의 길이를 n에 저장합니다.

        for (int i = 1; i < n; i++) {
            int key = arr[i];  // 현재 비교할 값을 key 변수에 저장합니다.
            int j = i - 1;     // 현재 비교할 위치의 이전 인덱스를 j에 저장합니다.

            while (j >= 0 && arr[j] > key) {
                // j가 0 이상이고, arr[j]가 key보다 큰 경우에 반복합니다.
                // 이 반복문은 key보다 큰 값을 오른쪽으로 이동시키면서 적절한 위치를 찾을 때까지 반복합니다.
                arr[j + 1] = arr[j];  // 현재 값(arr[j])을 오른쪽으로 한 칸 이동시킵니다.
                j--;                 // j를 한 칸 왼쪽으로 이동하여 이전 위치의 값과 비교합니다.
            }

            arr[j + 1] = key;  // key 값을 현재 위치(j + 1)에 저장하여 정렬을 완료합니다.
        }
    }
}