import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int k;
    private static int[] nums;
    private static int[] preSum;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        findPrefixSum();
        findAnswer();
        System.out.println(answer);
    }

    private static void findAnswer() {
        for (int i = 1; i <= n - k + 1; i++) {
            answer = Math.max(answer, getSum(i, i + k - 1));
        }
    }

    private static int getSum(int i, int i1) {
        return preSum[i1] - preSum[i - 1];
    }

    private static void findPrefixSum() {
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());

        preSum = new int[n + 1];
        nums = new int[n + 1];
        tokenizer = new StringTokenizer(input.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            nums[i] = num;
        }
    }
}