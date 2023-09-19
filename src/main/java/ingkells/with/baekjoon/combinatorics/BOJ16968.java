package ingkells.with.baekjoon.combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

// 백준 16968. 차량 번호판 1
public class BOJ16968 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] string = st.nextToken().split("");
        Map<String, Integer> map = new HashMap<>();
        map.put("d",10);
        map.put("c",26);
        int result = 1;
        for(int i=0;i<string.length;i++){
            if(i>0 && string[i].equals(string[i-1])){
                result *= map.get(string[i])-1;
            }else{
                result *= map.get(string[i]);
            }
        }
        System.out.println(result);
    }
}
