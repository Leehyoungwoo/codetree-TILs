package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int RANGE = 1_000_000_000;
    private static int n;
    private static int m;
    private static TreeMap<Integer, Integer> map = new TreeMap<>();
    private static Queue<int[]> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();
        init();
        for (int i = 0; i < m; i++) {
            int[] poll = que.poll();
            int left = poll[0];
            int right = poll[1];
            int num = findAnswer(left, right);
            answer.append(num).append("\n");
        }

        System.out.println(answer);
    }

    private static int findAnswer(int left, int right) {
        int first = 0;
        int last = 0;

        if (right < map.firstKey()) {
            return 0;
        }

        if (left > map.lastKey()) {
            return 0;
        }

        if (map.ceilingEntry(left) != null) {
            first = map.ceilingEntry(left).getValue();
        } else {
            first = 0;
        }

        if (map.floorEntry(right) != null) {
            last = map.floorEntry(right).getValue();
        } else {
            last = n;
        }

        return (last - first + 1);
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[n];
        tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i + 1);
        }
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            que.offer(new int[]{start, end});
        }
    }
}