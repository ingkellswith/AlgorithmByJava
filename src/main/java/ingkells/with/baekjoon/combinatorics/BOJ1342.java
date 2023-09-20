package ingkells.with.baekjoon.combinatorics;

import java.util.Scanner;

// 백준 1342. 행운의 문자열

public class BOJ1342{
    static int[] alphabet = new int[27];
    static int count;
    static int length;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        length = str.length();
        for (int i = 0; i < str.length(); i++)alphabet[str.charAt(i)-'a']++;

        dfs(0,' ');
        System.out.println(count);
    }

    public static void dfs(int index,char pre){
        if (index==length){
            count++;
            return;
        }

        // 주의할 점은 조합과 달리 int i = index;가 아니라 int i = 0;이라는 것이다.
        for (int i = 0; i < 27; i++){
            if (alphabet[i]==0)continue;

            if (pre != (char) (i+'a')){
                alphabet[i]--;
                dfs(index+1, (char)(i+'a'));
                alphabet[i]++;
            }

        }
    }
}
