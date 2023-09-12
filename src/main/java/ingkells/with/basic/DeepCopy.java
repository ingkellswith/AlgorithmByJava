package ingkells.with.basic;

public class DeepCopy {

    public static void restoreArray(int[][] original, int[][] restored) {
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, restored[i], 0, original[i].length);
        }
    }

    public static void restoreArray2(int[][] original, int[][] restored) {
        for (int i = 0; i < original.length; i++) {
            restored[i]=original[i].clone();
        }
    }
    public static void main(String[] args) {
        int[][] original = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] copy = {{1,2,3},{4,5,6},{7,8,9}};

        copy[0][0] = 10;
        copy[0][1] = 20;
        copy[0][2] = 30;

        restoreArray2(original, copy);

        // 원본 객체와 복제된 객체의 값을 출력
        System.out.println("Original Value: " + original[0][0]);
        System.out.println("Clone Value: " + copy[0][0]);
    }
}
