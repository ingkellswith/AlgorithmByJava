package ingkells.with.baekjoon.theory.combinatorics;

public class PermutationVer2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        generatePermutations(arr, 0);
    }

    public static void generatePermutations(int[] arr, int currentIndex) {
        if (currentIndex == arr.length - 1) {
            // 순열이 완성된 경우 출력
            printArray(arr);
            return;
        }

        for (int i = currentIndex; i < arr.length; i++) {
            // 현재 위치의 원소와 다른 위치의 원소를 교환
            swap(arr, currentIndex, i);

            // 다음 위치의 순열 생성
            generatePermutations(arr, currentIndex + 1);

            // 원래대로 돌려놓기 (백트래킹)
            swap(arr, currentIndex, i);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}