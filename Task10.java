import java.util.*;

class Task10 {
    private int[][] result;
    private int[][] matrixA;
    private int[][] matrixB;
    private int rows, cols;

    public Task10(int[][] matrixA, int[][] matrixB) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.rows = matrixA.length;
        this.cols = matrixB[0].length;
        this.result = new int[rows][cols];
    }

    class Worker implements Runnable {
        private int row;

        public Worker(int row) {
            this.row = row;
        }

        @Override
        public void run() {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < matrixB.length; k++) {
                    result[row][j] += matrixA[row][k] * matrixB[k][j];
                }
            }
        }
    }

    public int[][] multiplyMatrices() {
        Thread[] threads = new Thread[rows];

        for (int i = 0; i < rows; i++) {
            threads[i] = new Thread(new Worker(i));
            threads[i].start();
        }

        for (int i = 0; i < rows; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrixA = {{1, 2}, {3, 4}};
        int[][] matrixB = {{2, 0}, {1, 2}};
        
        Task10 multiplier = new Task10(matrixA, matrixB);
        int[][] result = multiplier.multiplyMatrices();
        
        System.out.println("Result of the multiplication:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
