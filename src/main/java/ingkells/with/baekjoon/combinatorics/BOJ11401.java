package ingkells.with.baekjoon.combinatorics;

import java.io.*;
import java.util.StringTokenizer;


// 백준 11401. 이항 계수 3
public class BOJ11401 {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long result = nCk(N, K);
        bw.write(String.valueOf(result));
        bw.newLine();

        br.close();
        bw.close();
    }

    // 빠른 거듭제곱을 사용하여 이항 계수를 계산하는 함수
    static long nCk(int n, int k) {
        if (k == 0 || n == k) {
            return 1;
        }

        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD; // 팩토리얼 계산 및 모듈로 연산
        }

        // 원소 a가 어떤 정수이고 p가 소수인 경우, 페르마의 소정리에 의해 다음이 성립합니다.
        // a^p ≡ a (mod p)
        // a^(p-1) ≡ 1 (mod p)
        // 이 식에서 **^**는 거듭제곱을 나타냅니다.
        // 위의 식에서 a의 역원은 **a^(p-2)**와 같다는 것을 알 수 있습니다.

        long denominator = (fact[k] * fact[n - k]) % MOD; // 분모 계산
        long exponent = pow(denominator, MOD - 2); // 페르마의 소정리를 사용한 역원 계산
        // long exponent = pow(denominator, MOD - 2) % MOD; // 이렇게 해도 정답처리
        long result = (fact[n] * exponent) % MOD; // 최종 결과 계산

        return result;
    }

    // 빠른 거듭제곱을 계산하는 함수
    static long pow(long base, long exponent) {
        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent /= 2;
        }
        return result;
    }
}