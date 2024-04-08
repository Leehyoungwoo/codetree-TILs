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
        StringBuilder builder = new StringBuilder();
        init();
        for (int i = 0; i < m; i++) {
            int target = que.poll();
            int answer = findAnswer(target);
            builder.append(answer).append("\n");
        }

        System.out.println(builder);
    }

    private static int findAnswer(int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (arr[left] != target) {
            return -1;
        }

        return left + 1;
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        arr = new int[n];
        tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < m; i++) {
            que.offer(Integer.parseInt(tokenizer.nextToken()));
        }
    }
}