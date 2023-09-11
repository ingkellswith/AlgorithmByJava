package ingkells.with.baekjoon.bfsanddfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 14502. 연구소
public class BOJ14502 {

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static List<List<Integer>> generateCombinations(int[] elements, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinationsHelper(elements, k, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void generateCombinationsHelper(int[] elements, int k, int start, List<Integer> currentCombination, List<List<Integer>> combinations) {
        if (k == 0) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i < elements.length; i++) {
            if(elements[i]==0) {
                currentCombination.add(i);
                generateCombinationsHelper(elements, k - 1, i + 1, currentCombination, combinations);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }

    public static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = new int[original[i].length];
            System.arraycopy(original[i], 0, copy[i], 0, original[i].length);
        }
        return copy;
    }

    public static void restoreArray(int[][] original, int[][] restored) {
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(restored[i], 0, original[i], 0, original[i].length);
        }
    }

    public static void restoreBooleanArray(boolean[][] original, boolean[][] restored) {
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(restored[i], 0, original[i], 0, original[i].length);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] originalMap = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        boolean[][] originalVisited = new boolean[n][m];
        int[] elements = new int[n*m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                originalMap[i][j] = map[i][j];
                visited[i][j] = false;
                originalVisited[i][j]=false;
                elements[i*m+j]=map[i][j];
            }
        }

        int wallCount = 3;

        List<List<Integer>> combinations = generateCombinations(elements, wallCount);

        int maxCount = 0;

        for (List<Integer> combination : combinations) {
            restoreArray(map, originalMap);
            restoreBooleanArray(visited, originalVisited);
            int a = combination.get(0);
            int b = combination.get(1);
            int c = combination.get(2);
            map[a/m][a%m]=1;
            map[b/m][b%m]=1;
            map[c/m][c%m]=1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j] == false && map[i][j] == 2) {
                        Queue<int[]> queue = new LinkedList<>();
                        visited[i][j] = true;
                        queue.add(new int[]{i,j});
                        while(!queue.isEmpty()){
                            int curX = queue.peek()[0];
                            int curY = queue.peek()[1];
                            queue.poll();
                            for(int k=0;k<4;k++){
                                int nX = curX+dx[k];
                                int nY = curY+dy[k];
                                if(nX>=0 && nY>=0 && nX<n && nY<m && map[nX][nY]==0){
                                    map[nX][nY]=2;
                                    queue.add(new int[]{nX,nY});
                                    visited[nX][nY]=true;
                                }
                            }
                        }
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j]==0){
                        count++;
                    }
                }
            }
            if(maxCount<=count){
                maxCount=count;
            }
        }

        System.out.println(maxCount);
    }
}
