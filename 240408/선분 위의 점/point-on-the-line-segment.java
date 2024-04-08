import java.util.*;

public class Main {
    public static final int MAX_N = 100000;

    public static int n, m;
    public static TreeMap<Integer, Integer> map = new TreeMap<>();
    public static int[] arr = new int[MAX_N];

    // target보다 크거나 같은 최초의 위치의 인덱스를 반환합니다.
    public static int lowerBound(int target) {
        Integer key = map.ceilingKey(target);
        if (key == null) {
            return n;
        }
        return map.get(key);
    }

    // target보다 큰 최초의 위치의 인덱스를 반환합니다.
    public static int upperBound(int target) {
        Integer key = map.higherKey(target);
        if (key == null) {
            return n;
        }
        return map.get(key);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        m = sc.nextInt();

        // 점의 좌표를 배열에 저장
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 좌표를 정렬하고, TreeMap에 저장
        Arrays.sort(arr, 0, n);
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        // m개의 질의에 대한 답을 계산합니다.
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            // b보다 큰 최초의 숫자 위치에서
            // a보다 크거나 같은 최초의 숫자 위치의 인덱스를 빼면
            // 문제에서 원하는 답이 됩니다.
            int count = upperBound(b) - lowerBound(a);
            System.out.println(count);
        }
    }
}