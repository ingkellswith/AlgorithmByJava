package ingkells.with.baekjoon.theory.combinatorics;

public class CombinationVer2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int r = 3; // 조합의 크기

        int[] data = new int[r];
        generateCombinations(arr, data, 0, 0);
    }

    public static void generateCombinations(int[] arr, int[] data, int start, int index) {
        int r = data.length;

        // 조합의 크기가 r에 도달하면 조합을 출력
        if (index == r) {
            printCombination(data);
            return;
        }

        // 배열 arr에서 조합 생성
        for (int i = start; i < arr.length; i++) {
            data[index] = arr[i];
            generateCombinations(arr, data, i + 1, index + 1);
        }
    }

    public static void printCombination(int[] data) {
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}