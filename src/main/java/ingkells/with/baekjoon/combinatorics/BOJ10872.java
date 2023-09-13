package ingkells.with.baekjoon.combinatorics;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 10872. 팩토리얼
public class BOJ10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        if(n==0){
            System.out.println(1);
            return;
        }
        int output=1;
        while(n>0){
            output*=n;
            n--;
        }
        System.out.println(output);
    }

}
