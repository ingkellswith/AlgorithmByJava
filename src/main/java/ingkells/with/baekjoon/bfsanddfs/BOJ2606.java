package ingkells.with.baekjoon.bfsanddfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 백준 2606. 바이러스

// 인접 행렬 풀이
//public class BOJ2606 {
//    static int map[][];		// 각 정점간 탐색 경로 저장
//    static boolean visit[];	// 정점 탐색여부 체크
//    static int n, m, v;		// 정점, 간선, 시작 정점
//    static int count = 0;	// 정점과 연결된 바이러스 걸리는 컴퓨터 수
//
//    public static int bfs(int i) {
//        Queue<Integer> q = new LinkedList<Integer>();
//        q.offer(i);
//        visit[i] = true;
//        while(!q.isEmpty()) {
//            int temp = q.poll();
//
//            for(int k=1; k<=n; k++) {
//                if(map[temp][k] == 1 && visit[k] == false) {
//                    q.offer(k);
//                    visit[k] = true;
//                    count ++;
//                }
//            }
//        }
//
//        return count;
//    }
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        n = scan.nextInt();	// 컴퓨터 수(정점)
//        m = scan.nextInt();	// 연결된 컴퓨터 쌍의 수(간선)
//        v = 1;	// 탐색 시장할 정점의 번호
//        map = new int[n+1][n+1];	// 각 정점간 탐색 경로를 저장할 배열
//        visit = new boolean[n+1];	// 정점의 탐색 여부 체크
//
//        // 인접행렬을 이용한 풀이
//        for(int i=0; i<m; i++) {
//            int a = scan.nextInt();
//            int b = scan.nextInt();
//            map[a][b] = map[b][a]= 1;
//        }
//
//        System.out.println(bfs(1));
//        scan.close();
//
//    }
//
//}



// 과거 풀이(틀림)

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;

//public class BOJ2606 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int nodeCount = Integer.parseInt(st.nextToken());
//
//        List<Integer>[] nodeList = new List[nodeCount+1];
//        for (int i = 1; i <= nodeCount; i++) {
//            nodeList[i] = new ArrayList<>();
//        }
//
//        st = new StringTokenizer(br.readLine());
//        int edgeCount = Integer.parseInt(st.nextToken());
//
//        for(int i = 1; i <= edgeCount; i++){
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            nodeList[a].add(b);
//        }
//
//        // bfs
//        int firstNode = 1;
//        boolean[] visited = new boolean[nodeCount+1];
//        for(int i=1;i<=nodeCount;i++){
//            visited[i]=false;
//        }
//        Queue<Integer> needVisit = new LinkedList<>();
//        int count = -1;
//        visited[firstNode] =true;
//        needVisit.add(firstNode);
//
//        while(needVisit.size()!=0){
//            int popped = needVisit.poll();
//            count+=1;
//            for (int i : nodeList[popped]) {
//                if (visited[i]) continue;
//                visited[i] = true;
//                needVisit.add(i);
//            }
//        }
//
//        System.out.println(count);
//    }
//
//}

// 인접 리스트 풀이(bfs, dfs 상관 없음)
import java.util.ArrayList;

public class BOJ2606 {
    static ArrayList<Integer>[] a;
    static boolean visit[];	// 정점 탐색여부 체크
    static int n, m, v;		// 정점, 간선, 시작 정점
    static int count = 0;	// 정점과 연결된 바이러스 걸리는 컴퓨터 수

    //    public static int dfs(int i) {
//        visit[i] = true;
//        for(int k : a[i]) {
//            if(visit[k] == false) {
//                count ++;
//                dfs(k);
//            }
//        }
//        return count;
//    }
    public static int bfs(int i) {
        Queue<Integer> needVisit = new LinkedList<>();
        visit[i] = true;
        needVisit.add(i);
        while(!needVisit.isEmpty()){
            int popped = needVisit.poll();
            for(int j : a[popped]){
                if(visit[j]==false){
                    count++;
                    visit[j] = true;
                    needVisit.add(j);
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();	// 컴퓨터 수(정점)
        m = scan.nextInt();	// 연결된 컴퓨터 쌍의 수(간선)
        v = 1;	// 탐색 시장할 정점의 번호
        a = new ArrayList[n+1];	// 인덱스 편의상 n+1설정, 0번째 요소는 사용 X
        visit = new boolean[n+1];
        for(int i=1; i<=n; i++) {
            a[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++) {
            int u = scan.nextInt();	// 간선으로 이어진 정점1
            int v = scan.nextInt();	// 정점1과 간선으로 이어진 정점2
            a[u].add(v);
            a[v].add(u);
        }

        System.out.println(bfs(v));

        scan.close();
    }

}
