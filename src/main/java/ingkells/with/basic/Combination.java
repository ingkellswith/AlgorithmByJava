package ingkells.with.basic;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int r = 2; // 조합의 크기

        List<List<Integer>> combinations = generateCombinations(arr, r);

        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }

    public static List<List<Integer>> generateCombinations(int[] arr, int r) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(arr, r, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generateCombinations(int[] arr, int r, int index, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == r) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (index == arr.length) {
            return;
        }

        // 현재 요소를 포함하는 경우
        current.add(arr[index]);
        generateCombinations(arr, r, index + 1, current, result);
        current.remove(current.size() - 1); // 백트래킹

        // 현재 요소를 포함하지 않는 경우
        generateCombinations(arr, r, index + 1, current, result);
    }
}