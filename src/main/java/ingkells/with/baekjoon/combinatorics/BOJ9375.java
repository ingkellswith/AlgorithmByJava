package ingkells.with.baekjoon.combinatorics;

import java.io.*;
import java.util.*;

// 백준 9375. 패션왕 신해빈
public class BOJ9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int z = 0; z < t; z++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String key = st.nextToken();
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int count = 1;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                count = count * (entry.getValue()+1);
            }
// 아래처럼 Entry대신에 keySet 사용도 가능
//            for (String key : map.keySet()) {
//                count = count * (map.get(key)+1);
//            }
            sb.append(count-1 + "\n");

        }
        System.out.print(sb);
    }
}
