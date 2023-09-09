package ingkells.with.baekjoon.theory.dfs;

import java.util.LinkedList;
import java.util.Stack;

class Graph {
    private int V; // 그래프의 노드 수
    private LinkedList<Integer>[] adj; // 인접 리스트

    // 그래프 초기화
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // 그래프에 간선 추가
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // DFS 반복문으로 구현
    void DFS(int s) {
        boolean[] visited = new boolean[V];

        Stack<Integer> needVisitStack = new Stack<>();
        needVisitStack.push(s);
        visited[s] = true;

        while (!needVisitStack.isEmpty()) {
            s = needVisitStack.pop();
            System.out.print(s + " ");

            for (Integer neighbor : adj[s]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    needVisitStack.push(neighbor);
                }
            }
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(7);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);

        System.out.println("DFS 탐색 결과 (시작 노드: 0):");
        g.DFS(0);
    }
}
