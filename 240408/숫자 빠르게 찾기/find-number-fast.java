import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
            int n = que.poll();
            int answer = binarySearch(n);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static int binarySearch(int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid + 1;
            }

            if (arr[mid] < target) {
                left = mid + 1;
                continue;
            }

            if (arr[mid] > target) {
                right = mid - 1;
            }
        }

        return -1;
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(input.readLine());
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        for (int i = 0; i < m; i++) {
            que.add(Integer.parseInt(input.readLine()));
        }
    }
}