import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int q = input.nextInt();

        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = input.nextInt();
        }

        for (int i = 0; i < q; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if ( start <=points[j] && points[j] <= end) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}