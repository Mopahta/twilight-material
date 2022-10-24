package by.mopahta.laba.task6;

public class MatrixChanger {

    public void testFunction () {
        int n = 20;
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = i;
        }
        toMatrix(digits);
    }

    private void toMatrix (int[] digits) {
        int size = digits.length;
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = digits[(i + j) % size];
                System.out.printf("%5d",matrix[i][j]);
            }
            System.out.println();
        }
    }
}
