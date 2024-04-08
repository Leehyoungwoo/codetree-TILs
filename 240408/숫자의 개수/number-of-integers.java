import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int[] arr;
    private static Queue<Integer> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        init();
        for (int i = 0; i < m; i++) {
            int num = que.poll();
            int answer = findAnswer(num);
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(input.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int i = 0; i < m; i++) {
            que.offer(Integer.parseInt(input.readLine()));
        }
    }

    private static int findAnswer(int target) {
        return upperBound(arr, target) - lowerBound(arr, target);
    }

    private static int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target <= arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target >= arr[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}