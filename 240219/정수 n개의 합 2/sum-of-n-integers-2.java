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

    public static void main(String[] args) throws IOException {
        init();
        Arrays.sort(preSum);
        System.out.println(preSum[n - 1]);
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());

        nums = new int[n];
        preSum = new int[n];
        tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            nums[i] += num;
            for (int j = k - 1; j >= 0; j--) {
                if (i - j < 0) {
                    continue;
                }
                preSum[i]+=nums[i - j];
            }
        }
    }
}