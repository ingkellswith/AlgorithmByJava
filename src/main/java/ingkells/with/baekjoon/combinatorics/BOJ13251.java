package ingkells.with.baekjoon.combinatorics;

import java.io.*;
import java.util.*;

// 백준 13251. 조약돌 꺼내기
// 문제를 잘 보면 경우의 수를 분자/분모로 하는 경우에는 수가 long의 범위를 초과해서 틀릴 수 밖에 없다. ex)100C50 = 100891344545564193334812497256
// 따라서 바로바로 확률을 계산해야 한다.
public class BOJ13251 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        int[] cnt = new int[M];
        double sum = 0.0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
            sum += cnt[i];
        }
        int K = Integer.parseInt(br.readLine());

        double answer = 0.0;
        for(int i = 0; i < M; i++) {
            double max = 1.0;
            for(int j = 0; j < K; j++) {
                max *= (cnt[i] - j) / (double)(sum - j);
            }
            answer += max;
        }
        System.out.println(answer);
    }
}