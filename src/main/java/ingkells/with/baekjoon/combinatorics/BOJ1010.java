package ingkells.with.baekjoon.combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1010. 다리 놓기
public class BOJ1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // N개 중에서 M개를 선택하는 조합을 계산하는 함수를 호출
            long result = calculateCombination(N, M);

            System.out.println(result);
        }

        br.close();
    }

    // 조합을 계산하는 함수
    private static long calculateCombination(int n, int m) {
        long result = 1;

        // mCn = (m * (m-1) * ... * (m-n+1)) / (1 * 2 * ... * n)
        for (int i = 1; i <= n; i++) {
            result = result * (m - i + 1) / i;
        }

        return result;
    }
}

// TODO : 재귀를 사용하면 메모리 초과
//public class BOJ1010 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//
//        while (T-- > 0) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int N = Integer.parseInt(st.nextToken());
//            int M = Integer.parseInt(st.nextToken());
//
//            // N개 중에서 M개를 선택하는 조합을 계산하는 함수를 호출
//            long result = binomialCoefficient(N, M);
//
//            System.out.println(result);
//        }
//
//        br.close();
//    }
//
//    // 조합을 계산하는 함수
//    private static int binomialCoefficient(int n, int k) {
//        if (k == 0 || k == n) {
//            return 1;
//        } else {
//            return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
//        }
//    }
//}