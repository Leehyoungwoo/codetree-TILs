import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int[] nums = new int[n + 1];
        tokenizer = new StringTokenizer(input.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n - 1; j++) {
                if (i <= j) {
                    continue;
                }
                if (prefixSum[i] - prefixSum[j] == k) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}