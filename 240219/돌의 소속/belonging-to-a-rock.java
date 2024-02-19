import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pre {
    int a;
    int b;
    int c;

    public Pre(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class Main {

    private static int n;
    private static int q;
    private static Queue<int[]> que = new LinkedList<>();
    private static int[] rocks;
    private static Pre[] preSum;

    public static void main(String[] args) throws IOException {
        init();
        findAnswer();
    }

    private static void findAnswer() {
        while (!que.isEmpty()) {
            int[] range = que.poll();
            int start = range[0];
            int end = range[1];
            System.out.print(preSum[end].a - preSum[start - 1].a + " ");
            System.out.print(preSum[end].b - preSum[start - 1].b + " ");
            System.out.print(preSum[end].c - preSum[start - 1].c + " ");
            System.out.println();
        }
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        q = Integer.parseInt(tokenizer.nextToken());
        rocks = new int[n + 1];
        preSum = new Pre[n + 1];

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(input.readLine());
            rocks[i] = num;
        }

        for (int i = 0; i <= n; i++) {
            preSum[i] = new Pre(0, 0, 0);
        }
        for (int i = 1; i <= q; i++) {
            tokenizer = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            que.offer(new int[]{a, b});
        }

        for (int i = 1; i <= n; i++) {
            if (rocks[i] == 1) {
                preSum[i].a = preSum[i - 1].a + 1;
                preSum[i].b = preSum[i - 1].b;
                preSum[i].c = preSum[i - 1].c;
                continue;
            }

            if (rocks[i] == 2) {
                preSum[i].a = preSum[i - 1].a;
                preSum[i].b = preSum[i - 1].b + 1;
                preSum[i].c = preSum[i - 1].c;
                continue;
            }

            if (rocks[i] == 3) {
                preSum[i].a = preSum[i - 1].a;
                preSum[i].b = preSum[i - 1].b;
                preSum[i].c = preSum[i - 1].c + 1;
            }
        }
    }
}