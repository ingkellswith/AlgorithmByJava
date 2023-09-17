package ingkells.with.baekjoon.combinatorics;

import java.math.BigInteger;
import java.util.Scanner;

// 백준 2407. 조합
// 백준 11050과 달리, 재귀를 사용하면 시간 초과
// 백준 11051과 달리, 파스칼의 삼각형 사용 불가, 메모리
public class BOJ2407 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 조합을 계산하는 메서드 호출
        BigInteger result = calculateCombination(n, m);

        System.out.println(result);
    }

    // 조합을 계산하는 메서드
    public static BigInteger calculateCombination(int n, int m) {
        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.ONE;

        // n! / (m! * (n-m)!) 계산
        for (int i = 0; i < m; i++) {
            numerator = numerator.multiply(BigInteger.valueOf(n - i));
            denominator = denominator.multiply(BigInteger.valueOf(i + 1));
        }

        return numerator.divide(denominator);
    }
}
