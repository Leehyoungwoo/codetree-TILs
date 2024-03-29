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
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            treeSet.add(nums[i]);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 1;
        for (Integer num : treeSet) {
            map.put(num, cnt);
            cnt++;
        }

        while (!que.isEmpty()) {
            int[] q = que.poll();
            int start = q[0];
            int end = q[1];
            System.out.println(map.get(end) - map.get(start) + 1);
        }
    }
}