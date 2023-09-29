package ingkells.with.baekjoon.minimumSpanningTree; // 패키지 선언

import java.io.*;
import java.util.*;

// 백준 1197. 최소 스패닝 트리
public class BOJ1197 {
    static int[] parent; // 부모 노드를 저장하는 배열

    static class Node implements Comparable<Node> {
        int to;
        int from;
        int value;

        public Node(int to, int from, int value) {
            this.to = to;
            this.from = from;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value; // 간선의 가중치를 기준으로 오름차순 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken()); // 정점의 개수
        int e = Integer.parseInt(st.nextToken()); // 간선의 개수

        parent = new int[v + 1]; // 각 정점의 부모 노드를 나타내는 배열
        for (int i = 1; i < v + 1; i++) {
            parent[i] = i; // 초기에는 자기 자신을 부모로 설정
        }

        Queue<Node> pq = new PriorityQueue<>(); // 우선순위 큐를 사용하여 간선을 가중치 기준으로 정렬
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Node(a, b, w)); // 간선 정보를 우선순위 큐에 추가
        }

        int size = pq.size();
        int total = 0; // 최소 스패닝 트리의 총 가중치

        // 크루스칼 알고리즘 수행
        for (int i = 0; i < size; i++) {
            Node node = pq.poll(); // 가장 가중치가 작은 간선을 선택

            if (!isSameParent(node.to, node.from)) { // 사이클을 형성하지 않으면
                total += node.value; // 가중치를 더하고
                union(node.to, node.from); // 두 노드를 합친다.
            }
        }
        System.out.println(total); // 최소 스패닝 트리의 총 가중치 출력
    }

    public static int find(int x) {
        if (parent[x] == x) return x; // 루트 노드인 경우 자기 자신을 반환
        return parent[x] = find(parent[x]); // 경로 압축을 통해 부모 노드 찾기
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x; // 두 집합을 합침
        }
    }

    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return true; // 같은 부모인 경우
        else return false; // 다른 부모인 경우
    }
}