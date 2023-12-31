package ingkells.with.baekjoon.combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 6603. 로또
public class BOJ6603 {
    static int[] numbers;
    static int[] result;
    static boolean[] visited;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                break;
            }

            numbers = new int[k];
            result = new int[6];
            visited = new boolean[k];

            for (int i = 0; i < k; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            generateCombinations(0, 0);
            System.out.println();
        }

        br.close();
    }

    // 조합을 생성하는 함수
    private static void generateCombinations(int start, int depth) {
        if (depth == 6) {
            printCombination();
            return;
        }

        for (int i = start; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = numbers[i];
                generateCombinations(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    // 조합을 출력하는 함수
    private static void printCombination() {
        for (int i = 0; i < 6; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}

// BOJ1759 암호 만들기 풀이와 비슷하게 풀이한 것
//        import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.StringTokenizer;
//
//public class Practice {
//    static int[] numbers;
//    static int[] result;
//    static boolean[] visited;
//    static int k;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        while (true) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            k = Integer.parseInt(st.nextToken());
//
//            if (k == 0) {
//                break;
//            }
//
//            numbers = new int[k];
//            result = new int[6];
//            visited = new boolean[k];
//
//            for (int i = 0; i < k; i++) {
//                numbers[i] = Integer.parseInt(st.nextToken());
//            }
//
//            int[] password = new int[6];
//            generateCombinations(0, 0, password);
//            System.out.println();
//        }
//
//        br.close();
//    }
//
//    // 조합을 생성하는 함수
//    private static void generateCombinations(int start, int depth, int[] password) {
//        if (depth == 6) {
//            for (int i = 0; i < 6; i++) {
//                System.out.print(password[i] + " ");
//            }
//            System.out.println();
//            return;
//        }
//
//        for (int i = start; i < k; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
//                password[depth] = numbers[i];
//                generateCombinations(i + 1, depth + 1, password);
//                visited[i] = false;
//            }
//        }
//    }
//
//}