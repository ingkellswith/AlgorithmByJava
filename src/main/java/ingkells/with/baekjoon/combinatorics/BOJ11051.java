package ingkells.with.baekjoon.combinatorics;

import java.util.Scanner;


// 백준 11051. 이항 계수 2
public class BOJ11051 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] Triangle = new int[N+1][N+1];

        for(int i = 0; i < Triangle.length; i++) {
            for(int j = 0; j <= i; j++) {
                if(i == j || j == 0)
                    Triangle[i][j] = 1;
                else
                    Triangle[i][j] = (Triangle[i-1][j-1] + Triangle[i-1][j]) % 10007;
            }
        }
        System.out.println(Triangle[N][K]);
    }
}