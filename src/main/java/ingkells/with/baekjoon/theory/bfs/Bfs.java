package ingkells.with.baekjoon.theory.bfs;

import java.util.LinkedList;
import java.util.Queue;

class Graph {
    private int V; // 그래프의 정점 수
    private LinkedList<Integer> adj[]; // 인접 리스트

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // 그래프에 간선 추가
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // BFS 탐색
    void BFS(int s) {
        boolean visited[] = new boolean[V];

        Queue<Integer> needVisitQueue = new LinkedList<>();
        visited[s] = true;
        needVisitQueue.add(s);

        while (!needVisitQueue.isEmpty()) {
            s = needVisitQueue.poll();
            System.out.print(s + " ");

            for (Integer neighbor : adj[s]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    needVisitQueue.add(neighbor);
                }
            }
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);

        System.out.println("BFS 탐색 결과 (시작 정점: 0):");
        g.BFS(0);
    }
}