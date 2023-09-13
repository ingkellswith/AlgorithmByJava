package ingkells.with.baekjoon.combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// 백준 1759. 암호 만들기
public class BOJ1759 {
    static int L, C;
    static char[] characters;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        characters = new char[C];
        visited = new boolean[C];

        input = br.readLine().split(" ");
        for (int i = 0; i < C; i++) {
            characters[i] = input[i].charAt(0);
        }

        Arrays.sort(characters); // 입력 문자 정렬
        generatePassword(0, 0, "");
        br.close();
    }

    // 암호를 생성하는 함수
    private static void generatePassword(int start, int count, String password) {
        if (count == L) {
            // 암호 조건에 맞는 경우 출력
            if (isPasswordValid(password)) {
                System.out.println(password);
            }
            return;
        }

        for (int i = start; i < C; i++) {
            if (!visited[i]) {
                visited[i] = true;
                generatePassword(i + 1, count + 1, password + characters[i]);
                visited[i] = false;
            }
        }
    }

    // 암호 조건을 검사하는 함수
    private static boolean isPasswordValid(String password) {
        int vowelCount = 0; // 모음 개수
        int consonantCount = 0; // 자음 개수

        for (char c : password.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }

        return vowelCount >= 1 && consonantCount >= 2;
    }
}