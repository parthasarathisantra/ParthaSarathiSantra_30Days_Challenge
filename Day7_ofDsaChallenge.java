import java.util.*;
import java.text.DecimalFormat;

public class Day7_ofDsaChallenge {


    private static TreeMap<Integer, Integer> leftMaxHeap = new TreeMap<>(Collections.reverseOrder());
    private static TreeMap<Integer, Integer> rightMinHeap = new TreeMap<>();
    private static int leftSize = 0;
    private static int rightSize = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String op = sc.next();
            int x = sc.nextInt();

            if (op.equals("a")) {
                add(x);
                printMedian();
            } else if (op.equals("r")) {
                if (remove(x)) {
                    printMedian();
                } else {
                    System.out.println("Wrong!");
                }
            }
        }
        sc.close();
    }

    private static void add(int x) {
        if (leftSize == 0 || x <= leftMaxHeap.firstKey()) {
            leftMaxHeap.put(x, leftMaxHeap.getOrDefault(x, 0) + 1);
            leftSize++;
        } else {
            rightMinHeap.put(x, rightMinHeap.getOrDefault(x, 0) + 1);
            rightSize++;
        }
        balance();
    }

    private static boolean remove(int x) {
        if (leftSize > 0 && x <= leftMaxHeap.firstKey() && leftMaxHeap.containsKey(x)) {
            removeFromMap(leftMaxHeap, x);
            leftSize--;
        } else if (rightSize > 0 && rightMinHeap.containsKey(x)) {
            removeFromMap(rightMinHeap, x);
            rightSize--;
        } else {
            return false;
        }
        balance();
        return true;
    }

    private static void removeFromMap(TreeMap<Integer, Integer> map, int x) {
        int count = map.get(x);
        if (count == 1) map.remove(x);
        else map.put(x, count - 1);
    }

    private static void balance() {
        if (leftSize > rightSize + 1) {
            int val = leftMaxHeap.firstKey();
            removeFromMap(leftMaxHeap, val);
            rightMinHeap.put(val, rightMinHeap.getOrDefault(val, 0) + 1);
            leftSize--;
            rightSize++;
        } else if (rightSize > leftSize) {
            int val = rightMinHeap.firstKey();
            removeFromMap(rightMinHeap, val);
            leftMaxHeap.put(val, leftMaxHeap.getOrDefault(val, 0) + 1);
            rightSize--;
            leftSize++;
        }
    }

    private static void printMedian() {
        if (leftSize == 0 && rightSize == 0) {
            System.out.println("Wrong!");
            return;
        }

        if ((leftSize + rightSize) % 2 != 0) {
            System.out.println(leftMaxHeap.firstKey());
        } else {
            long sum = (long) leftMaxHeap.firstKey() + (long) rightMinHeap.firstKey();
            if (sum % 2 == 0) {
                System.out.println(sum / 2);
            } else {
                double result = sum / 2.0;
                System.out.println(new DecimalFormat("0.#").format(result));
            }
        }
    }
}