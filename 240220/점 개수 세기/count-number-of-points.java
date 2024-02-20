import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n;
    private static int q;
    private static int[] nums;
    private static Queue<int[]> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        init();
        findAnswer();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        q = Integer.parseInt(tokenizer.nextToken());

        nums = new int[n];
        tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int i = 0; i < q; i++) {
            tokenizer = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            que.offer(new int[]{start, end});
        }
    }

    private static void findAnswer() {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        int cnt = 1;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Integer num : set) {
            map.put(num, cnt);
            cnt++;
        }

        while (!que.isEmpty()) {
            int[] range = que.poll();
            int start = map.ceilingKey(range[0]);
            int end = map.floorKey(range[1]);
            Integer large = map.floorEntry(end).getValue();
            Integer small = map.ceilingEntry(start).getValue();
            System.out.println(large - small + 1);
        }
    }
}