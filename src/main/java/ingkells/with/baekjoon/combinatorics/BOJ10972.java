package ingkells.with.baekjoon.combinatorics;

// 백준 10972. 다음 순열
import java.util.Scanner;

public class BOJ10972 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        if (nextPermutation(arr)) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println(-1); // 다음 순열이 없는 경우 -1 출력
        }
    }

    public static boolean nextPermutation(int[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i < 0) {
            return false; // 다음 순열이 없는 경우
        }

        int j = arr.length - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }

        // i와 j 위치의 원소 교환
        swap(arr, i, j);

        // i 위치 이후의 원소를 뒤집기
        reverse(arr, i + 1);

        return true;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] arr, int start) {
        int end = arr.length - 1;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.math.BigInteger;
//import java.util.Scanner;
//import java.util.StringTokenizer;

// 첫 풀이, 답은 맞는 것 같으나 시간 초과
//public class BOJ10972 {
//
//    static int n;
//
//    static boolean[] visited;
//    static int[] numbers;
//    static int[] result;
//    static int[] beforeList;
//    static boolean trigger = false;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        numbers = new int[n];
//        visited = new boolean[n];
//        result = new int[n];
//        beforeList = new int[n];
//        st = new StringTokenizer(br.readLine());
//        for(int i=0;i<n;i++){
//            numbers[i] = i+1;
//            beforeList[i] = Integer.parseInt(st.nextToken());
//        }
//
//        getCombination(0, 0);
//    }
//
//    public static void getCombination(int start, int depth){
//        if(result.length==n){
//            int minusCount = 0;
//            for(int i=n-1, j=0; i>=0;i--,j++){
//                if(result[j]==i+1){
//                    minusCount += 1;
//                }
//            }
//            if(minusCount==n){
//                System.out.println(-1);
//                return;
//            }
//            if(trigger==true){
//                for(int i=0; i<n;i++){
//                    System.out.print(result[i] + " ");
//                }
//                trigger=false;
//                return;
//            }
//            int correctCount = 0;
//            for(int i=0; i<n;i++){
//                if(result[i]==beforeList[i]){
//                    correctCount += 1;
//                }
//            }
//            if(correctCount==n){
//                trigger=true;
//            }
//        }
//
//        for(int i=start;i<n;i++){
//            if(!visited[i]){
//                visited[i]=true;
//                swap(depth,i);
//                result[depth]=numbers[i];
//                getCombination(start+1,depth+1);
//                swap(depth,i);
//                visited[i]=false;
//            }
//        }
//    }
//
//    public static void swap(int i, int j) {
//        int temp = result[i];
//        result[i] = result[j];
//        result[j] = temp;
//    }
//}
