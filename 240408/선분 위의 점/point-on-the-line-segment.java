import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static final int MAX_N = 100000;

    public static int n, m;
    public static TreeMap<Integer, Integer> map = new TreeMap<>();

    // target보다 큰 최초의 위치를 반환합니다.
    public static int upperBound(int target) {
        Integer key = map.ceilingKey(target);
        if (key == null) {
            return n;
        }
        return map.get(key);
    }

    // target보다 같거나 큰 최초의 위치를 반환합니다.
    public static int lowerBound(int target) {
        Integer key = map.floorKey(target);
        if (key == null) {
            return 0;
        }
        return map.get(key);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            map.put(num, i);
        }

        // m개의 질의에 대한 답을 계산합니다.
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            // b보다 큰 최초의 숫자 위치에서
            // a보다 같거나 큰 최초의 숫자 위치를 빼면
            // 문제에서 원하는 답이 됩니다.
            int count = upperBound(b) - lowerBound(a);
            System.out.println(count);
        }
    }
}