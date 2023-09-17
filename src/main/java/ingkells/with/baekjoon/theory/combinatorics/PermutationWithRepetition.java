package ingkells.with.baekjoon.theory.combinatorics;

import java.util.ArrayList;
import java.util.List;

public class PermutationWithRepetition {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int r = 2; // 중복 순열의 크기

        List<List<Integer>> permutations = generatePermutations(arr, r);

        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }

    public static List<List<Integer>> generatePermutations(int[] arr, int r) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(arr, r, new ArrayList<>(), result);
        return result;
    }

    private static void generatePermutations(int[] arr, int r, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == r) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            current.add(arr[i]);
            generatePermutations(arr, r, current, result);
            current.remove(current.size() - 1);
        }
    }
}
