package ingkells.with.baekjoon.combinatorics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
// 백준 11401. 이항 계수 3
// 원소 a가 어떤 정수이고 p가 소수인 경우, 페르마의 소정리에 의해 다음이 성립합니다.
// a^p ≡ a (mod p)
// a^(p-1) ≡ 1 (mod p)
// 이 식에서 **^**는 거듭제곱을 나타냅니다.
// 위의 식에서 a의 역원은 **a^(p-2)**와 같다는 것을 알 수 있습니다.
// https://st-lab.tistory.com/241
// 전체 풀이 참고
public class BOJ11401 {

    final static long P = 1000000007;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        // 분자 N!
        long numer = factorial(N);

        // 분모 (K! * (N-K)!) mod p
        long denom = factorial(K) * factorial(N - K) % P;


        // N! * 분모의 역원((K! * (N-K)!)
        System.out.println(numer * pow(denom, P - 2) % P);

    }


    // 팩토리얼 함수
    public static long factorial(long N) {
        long fac = 1L;

        while(N > 1) {
            // 곱셈에서는 모듈러의 분배 법칙에 의해서 모듈러를 많이 계산해도 된다.
            fac = (fac * N) % P;
            N--;
        }
        return fac;
    }


    /*
     * 역원 구하는 함수
     *
     * base : 밑,   expo = 지수 (exponent)
     *
     * 거듭 제곱을 분할 정복 방식으로 푼다.
     *
     */
    public static long pow(long base, long expo) {
        // 지수가 1일 경우 base^1 이므로 base % P를 리턴
        if(expo == 1) {
            return base % P;
        }

        // 지수의 절반에 해당하는 base^(expo / 2) 을 구한다.
        long temp = pow(base, expo / 2);

        /*
         * 현재 지수가 홀 수 였다면
         * base^(expo / 2) * base^(expo / 2) * base 이므로
         * base를 한 번 더 곱해주어야 한다.
         *
         * ex) A^9 = A^4 * A^4 * A
         */
        if(expo % 2 == 1) {
            return (temp * temp % P) * base % P;
        }
        return temp * temp % P;

    }


}