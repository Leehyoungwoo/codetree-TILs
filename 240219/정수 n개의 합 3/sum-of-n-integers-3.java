import java.util.Scanner;

public class Main {
    public static int findMaximumSum(int n, int k, int[][] grid) {
        int maxSum = 0;

        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                int squareSum = 0;

                for (int x = 0; x < k; x++) {
                    for (int y = 0; y < k; y++) {
                        squareSum += grid[i + x][j + y];
                    }
                }

                maxSum = Math.max(maxSum, squareSum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        int result = findMaximumSum(n, k, grid);

        System.out.println(result);
    }
}