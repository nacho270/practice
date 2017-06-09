package otros;

public class RecursiveSpiralMatrix {

    private static void spiralTraverse(final Matrix<Integer> m) {
        spiralTraverse(m, 0, m.getWidth() - 1, 0, m.getHeight() - 1);
    }

    private static void printMatrixInSpiralWayUsingRecursion(final int[][] matrix, final int rowStart, final int colStart,
            final int colLength, final int rowLength) {
        for (int i = rowStart; i <= colLength; i++) {
            System.out.print(matrix[rowStart][i] + " ");
        }
        for (int i = rowStart + 1; i <= rowLength; i++) {
            System.out.print(matrix[i][colLength] + " ");
        }

        if (rowStart + 1 <= rowLength) {
            for (int i = colLength - 1; i >= colStart; i--) {
                System.out.print(matrix[rowLength][i] + " ");
            }
        }

        if (colStart + 1 <= colLength) {
            for (int i = rowLength - 1; i > rowStart; i--) {
                System.out.print(matrix[i][colStart] + " ");
            }
        }

        if (rowStart + 1 <= rowLength - 1 && colStart + 1 <= colLength - 1) {
            printMatrixInSpiralWayUsingRecursion(matrix, rowStart + 1, colStart + 1, colLength - 1, rowLength - 1);
        }
    }

    private static <T> void spiralTraverse(final Matrix<T> m, final int rowStart, final int rowEnd, final int colStart,
            final int colEnd) {
        // left to right
        for (int i = rowStart; i <= rowEnd; i++) {
            System.out.println(m.get(i, rowStart));
        }

        // top down
        for (int i = rowStart + 1; i <= colEnd; i++) {
            System.out.println(m.get(rowEnd, i));
        }

        // right to left
        if (rowStart + 1 <= rowEnd) {
            for (int i = rowEnd - 1; i > rowStart; i--) {
                System.out.println(m.get(i, colEnd));
            }
        }

        // bottom up
        // if(rowStart+1 <= colLength) {
        // for (int i = colEnd - 1; i > colStart; i--) {
        // System.out.println(m.get(rowStart, i));
        // }
        // }
        // spiralTraverse(m, rowStart + 1, rowEnd - 1, colStart + 1, colEnd - 1);
    }

    private static class Matrix<T> {

        private final T[][] elements;

        public Matrix(final T[][] elements) {
            this.elements = elements;
        }

        public T get(final int x, final int y) {
            return elements[y][x];
        }

        public int getHeight() {
            return elements.length;
        }

        public int getWidth() {
            return elements[0].length;
        }
    }

    public static void main(final String[] args) {
        // runNPalindrome("pepe");
        // checkSum(new int[] { 1, 2, 3, 4, 5 }, new int[] { 10, 11, 12, 13, 14 }, 13);

        final Matrix<Integer> m = new Matrix<>(
                new Integer[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 }, { 13, 14, 15 } });
        spiralTraverse(m);
        final int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 }, { 13, 14, 15 } };
        printMatrixInSpiralWayUsingRecursion(matrix, 0, 0, matrix[0].length - 1, matrix.length - 1);
    }
}
