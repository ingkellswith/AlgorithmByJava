package ingkells.with.bfsanddfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] child;
    static boolean[] visited;

    static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(' ');

        for (int i : child[node]) {
            if (visited[i]) continue;
            dfs(i);
        }
    }

    static void bfs(int node) {
        Deque<Integer> dq = new ArrayDeque<>();
        visited[node] = true;
        dq.addLast(node);

        while(!dq.isEmpty()) {
            int cur = dq.removeFirst();
            sb.append(cur).append(' ');

            for (int i : child[cur]) {
                if (visited[i]) continue;
                visited[i] = true;
                dq.addLast(i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int V = Integer.parseInt(stk.nextToken());

        child = new List[N+1];
        for (int i = 1; i <= N; i++) {
            child[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            child[a].add(b);
            child[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(child[i]);
        }

        visited = new boolean[N+1];
        dfs(V);

        sb.append('\n');

        visited = new boolean[N+1];
        bfs(V);

        System.out.print(sb);

    }
}