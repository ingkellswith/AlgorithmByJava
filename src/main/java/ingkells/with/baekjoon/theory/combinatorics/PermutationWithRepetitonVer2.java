package ingkells.with.baekjoon.theory.combinatorics;

public class PermutationWithRepetitonVer2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int r = 3; // 순열의 길이

        int[] data = new int[r];
        generatePermutationsWithRepetition(arr, data, 0);
    }

    public static void generatePermutationsWithRepetition(int[] arr, int[] data, int index) {
        int r = data.length;

        // 순열의 길이가 r에 도달하면 순열을 출력
        if (index == r) {
            printPermutation(data);
            return;
        }

        // 배열 arr에서 중복 순열 생성
        for (int i = 0; i < arr.length; i++) {
            data[index] = arr[i];
            generatePermutationsWithRepetition(arr, data, index + 1);
        }
    }

    public static void printPermutation(int[] data) {
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}