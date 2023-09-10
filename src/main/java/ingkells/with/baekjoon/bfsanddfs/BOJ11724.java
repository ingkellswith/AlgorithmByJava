package ingkells.with.baekjoon.bfsanddfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 11724. 연결 요소의 개수
public class BOJ11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] nodeList = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            nodeList[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodeList[a].add(b);
            nodeList[b].add(a);
        }

        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i = 1; i<=n; i++){
            if(!visited[i]){
                count+=1;
                visited[i]=true;
                queue.add(i);
                while(!queue.isEmpty()){
                    int popped = queue.poll();
                    for(int element : nodeList[popped]){
                        if(!visited[element]) {
                            visited[element] = true;
                            queue.add(element);
                        }
                    }
                }
            }
        }

        System.out.println(count);

    }
}
