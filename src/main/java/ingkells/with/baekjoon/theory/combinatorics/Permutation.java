package ingkells.with.baekjoon.theory.combinatorics;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] elements = {1, 2, 3, 4, 5};
        int r = 3; // 뽑을 요소의 수
        List<List<Integer>> permutations = generatePermutations(elements, r);

        // 생성된 순열 출력
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }

    public static List<List<Integer>> generatePermutations(int[] elements, int r) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutationsHelper(elements, r, new ArrayList<>(), result);
        return result;
    }

    private static void generatePermutationsHelper(int[] elements, int r, List<Integer> currentPermutation, List<List<Integer>> result) {
        if (currentPermutation.size() == r) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            if (!currentPermutation.contains(elements[i])) {
                currentPermutation.add(elements[i]);
                generatePermutationsHelper(elements, r, currentPermutation, result);
                currentPermutation.remove(currentPermutation.size() - 1);
            }
        }
    }
}





