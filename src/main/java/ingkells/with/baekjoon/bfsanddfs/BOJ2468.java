package ingkells.with.baekjoon.bfsanddfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 백준 2468. 안전 영역
public class BOJ2468 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        boolean[][] drown = new boolean[n][n];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int max = 0;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]>=max){
                    max=map[i][j];
                }
            }
        }

        int maxAliveCount = 0;
        for(int rain=0;rain<=max;rain++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    drown[i][j]=false;
                    if(map[i][j]<=rain){
                        drown[i][j]=true;
                    }
                }
            }

            int aliveCount = 0;

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(drown[i][j]==false){
                        aliveCount++;
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{i,j});
                        drown[i][j]=true;
                        while(!queue.isEmpty()){
                            int curx = queue.peek()[0];
                            int cury = queue.peek()[1];
                            queue.poll();
                            for(int k=0;k<4;k++){
                                int nx = curx+dx[k];
                                int ny = cury+dy[k];
                                if(nx>=0 && ny>=0 && nx<n && ny<n && drown[nx][ny]==false){
                                    drown[nx][ny]=true;
                                    queue.add(new int[]{nx,ny});
                                }
                            }
                        }
                    }
                }
            }

            if(maxAliveCount<=aliveCount){
                maxAliveCount=aliveCount;
            }
        }

        System.out.println(maxAliveCount);
    }
}
